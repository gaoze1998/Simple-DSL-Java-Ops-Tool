package com.ze.gao.parser;

import com.ze.gao.parser.base.SimpleParserBaseVisitor;
import com.ze.gao.parser.base.SimpleParserParser;
import lombok.Getter;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class SpelVisitor extends SimpleParserBaseVisitor<String> {
    private final StandardEvaluationContext context;

    @Getter
    private final SpelExpressionParser parser = new SpelExpressionParser();

    public SpelVisitor(StandardEvaluationContext context) {
        this.context = context;
    }

    @Override
    public String visitStatement(SimpleParserParser.StatementContext ctx) {
        if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment());
        } else if (ctx.expression() != null) {
            return visitExpression(ctx.expression());
        }
        return null;
    }

    @Override
    public String visitAssignment(SimpleParserParser.AssignmentContext ctx) {
        String left = visitLeftExpression(ctx.leftExpression());
        String right = visitRightExpression(ctx.rightExpression());
        return left + " = " + right;
    }

    @Override
    public String visitLeftExpression(SimpleParserParser.LeftExpressionContext ctx) {
        return visitPathExpression(ctx.pathExpression());
    }

    @Override
    public String visitRightExpression(SimpleParserParser.RightExpressionContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public String visitExpression(SimpleParserParser.ExpressionContext ctx) {
        if (ctx.pathExpression() != null) {
            return visitPathExpression(ctx.pathExpression());
        } else if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.functionCall() != null) {
            return visitFunctionCall(ctx.functionCall());
        }
        return null;
    }

    @Override
    public String visitPathExpression(SimpleParserParser.PathExpressionContext ctx) {
        StringBuilder path = new StringBuilder(visitIdentifier(ctx.identifier()));
        for (SimpleParserParser.PathComponentContext component : ctx.pathComponent()) {
            path.append('.').append(visitPathComponent(component));
            String el = path.toString();
            Class<?> valueType = parser.parseExpression(el).getValueType(context);

            if (valueType != null && valueType.isAssignableFrom(ArrayList.class)) {
                List<?> value = parser.parseExpression(el).getValue(context, List.class);
                if (value == null || value.size() == 0) {
                    throw new RuntimeException("array access is null [%s]".formatted(el));
                }
                if (value.size() == 1) {
                    path.append("[0]");
                }
            }
        }

        return path.toString();
    }

    @Override
    public String visitPathComponent(SimpleParserParser.PathComponentContext ctx) {
        if (ctx.identifier() != null) {
            return visitIdentifier(ctx.identifier());
        } else if (ctx.arrayAccess() != null) {
            return visitArrayAccess(ctx.arrayAccess());
        }
        return null;
    }

    @Override
    public String visitArrayAccess(SimpleParserParser.ArrayAccessContext ctx) {
        String identifier = visitIdentifier(ctx.identifier());
        String filter = visitFilterExpression(ctx.filterExpression());
        return identifier + ".?" + "[" + filter + "]";
    }

    @Override
    public String visitFilterExpression(SimpleParserParser.FilterExpressionContext ctx) {
        if (ctx.simpleFilter() != null) {
            return visitSimpleFilter(ctx.simpleFilter());
        } else if (ctx.functionCall() != null) {
            return visitFunctionCall(ctx.functionCall());
        } else if (ctx.logicalExpression() != null) {
            return visitLogicalExpression(ctx.logicalExpression());
        }
        return null;
    }

    @Override
    public String visitSimpleFilter(SimpleParserParser.SimpleFilterContext ctx) {
        String identifier = visitIdentifier(ctx.identifier());
        String literal = visitLiteral(ctx.literal());
        return identifier + " = " + literal;
    }

    @Override
    public String visitLogicalExpression(SimpleParserParser.LogicalExpressionContext ctx) {
        StringBuilder logicalExpr = new StringBuilder();

        // 获取所有条件
        List<SimpleParserParser.ConditionContext> conditions = ctx.condition();
        if (!conditions.isEmpty()) {
            logicalExpr.append(visitCondition(conditions.get(0))); // 处理第一个条件
        }

        // 遍历逻辑运算符
        for (int i = 0; i < ctx.logicalOperator().size(); i++) {
            logicalExpr.append(' ').append(visitLogicalOperator(ctx.logicalOperator(i))).append(' '); // 添加运算符
            logicalExpr.append(visitCondition(conditions.get(i + 1))); // 处理下一个条件
        }

        return logicalExpr.toString();
    }

    @Override
    public String visitCondition(SimpleParserParser.ConditionContext ctx) {
        String identifier = visitIdentifier(ctx.identifier());
        String comparisonOperator = visitComparisonOperator(ctx.comparisonOperator());
        String operand = ctx.literal() != null ? visitLiteral(ctx.literal()) : visitExpression(ctx.expression());
        return identifier + " " + comparisonOperator + " " + operand;
    }

    @Override
    public String visitFunctionCall(SimpleParserParser.FunctionCallContext ctx) {
        String identifier = "#" + visitIdentifier(ctx.identifier());
        StringBuilder args = new StringBuilder();
        for (SimpleParserParser.FunctionArgContext arg : ctx.functionArgs().functionArg()) {
            if (!args.isEmpty()) {
                args.append(", ");
            }
            args.append(visitFunctionArg(arg));
        }
        return identifier + "(" + args + ")";
    }

    @Override
    public String visitFunctionArgs(SimpleParserParser.FunctionArgsContext ctx) {
        List<SimpleParserParser.FunctionArgContext> args = ctx.functionArg();
        List<String> argStrings = new ArrayList<>();
        for (SimpleParserParser.FunctionArgContext arg : args) {
            argStrings.add(visitFunctionArg(arg));
        }
        return String.join(", ", argStrings);
    }

    @Override
    public String visitFunctionArg(SimpleParserParser.FunctionArgContext ctx) {
        if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.pathExpression() != null) {
            return visitPathExpression(ctx.pathExpression());
        }
        return null;
    }

    @Override
    public String visitLiteral(SimpleParserParser.LiteralContext ctx) {
        if (ctx.stringLiteral() != null) {
            return visitStringLiteral(ctx.stringLiteral());
        } else if (ctx.numberLiteral() != null) {
            return visitNumberLiteral(ctx.numberLiteral());
        }
        return "";
    }

    @Override
    public String visitStringLiteral(SimpleParserParser.StringLiteralContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitNumberLiteral(SimpleParserParser.NumberLiteralContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitLogicalOperator(SimpleParserParser.LogicalOperatorContext ctx) {
        if (ctx.getText().equals("and")) {
            return "&&";
        } else {
            return "||";
        }
    }

    @Override
    public String visitComparisonOperator(SimpleParserParser.ComparisonOperatorContext ctx) {
        if (ctx.getText().equals("=")) {
            return "==";
        }
        return ctx.getText();
    }

    @Override
    public String visitIdentifier(SimpleParserParser.IdentifierContext ctx) {
        return ctx.getText();
    }
}
