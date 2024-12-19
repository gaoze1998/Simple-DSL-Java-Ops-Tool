package com.ze.gao.parser;

import com.ze.gao.parser.base.SimpleParserBaseVisitor;
import com.ze.gao.parser.base.SimpleParserParser;
import lombok.Getter;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpelVisitor extends SimpleParserBaseVisitor<List<String>> {
    private final StandardEvaluationContext context;

    @Getter
    private final SpelExpressionParser parser = new SpelExpressionParser();

    public SpelVisitor(StandardEvaluationContext context) {
        this.context = context;
    }

    @Override
    public List<String> visitStatement(SimpleParserParser.StatementContext ctx) {
        if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment());
        } else if (ctx.expression() != null) {
            return visitExpression(ctx.expression());
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> visitAssignment(SimpleParserParser.AssignmentContext ctx) {
        List<String> left = visitLeftExpression(ctx.leftExpression());
        List<String> right = visitRightExpression(ctx.rightExpression());
        if (right.size() != 1) {
            throw new RuntimeException("right expression must be a single value");
        }
        // zip left and right with '='
        List<String> result = new ArrayList<>();
        for (String s : left) {
            result.add(s + " = " + right.get(0));
        }
        return result;
    }

    @Override
    public List<String> visitLeftExpression(SimpleParserParser.LeftExpressionContext ctx) {
        return visitPathExpression(ctx.pathExpression());
    }

    @Override
    public List<String> visitRightExpression(SimpleParserParser.RightExpressionContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public List<String> visitExpression(SimpleParserParser.ExpressionContext ctx) {
        if (ctx.pathExpression() != null) {
            return visitPathExpression(ctx.pathExpression());
        } else if (ctx.literal() != null) {
            return List.of(_visitLiteral(ctx.literal()));
        } else if (ctx.functionCall() != null) {
            return List.of(_visitFunctionCall(ctx.functionCall()));
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> visitPathExpression(SimpleParserParser.PathExpressionContext ctx) {
        List<String> paths = new ArrayList<>();

        StringBuilder path = new StringBuilder(_visitIdentifier(ctx.identifier()));
        for (SimpleParserParser.PathComponentContext component : ctx.pathComponent()) {
            Class<?> valueType = parser.parseExpression(path.toString()).getValueType(context);
            if (valueType != null && valueType.isAssignableFrom(ArrayList.class)) {
                List<String> finalPathPrefix = new ArrayList<>();
                incur(path.toString(), finalPathPrefix);
                finalPathPrefix.forEach(p -> paths.add(p + "." + _visitPathComponent(component)));
            } else {
                path.append(".").append(_visitPathComponent(component));
            }
        }

        if (paths.isEmpty()) {
            paths.add(path.toString());
        }
        return paths;
    }

    private void incur(String path, List<String> finalPathPrefix) {
        List<?> value = parser.parseExpression(path).getValue(context, List.class);
        if (value == null) {
            return;
        }
        int n = value.size();
        for (int i = 0; i < n; i++) {
            Class<?> valueType = parser.parseExpression(path + "[" + i + "]").getValueType(context);
            if (valueType != null && valueType.isAssignableFrom(ArrayList.class)) {
                incur(path + "[" + i + "]", finalPathPrefix);
            } else {
                finalPathPrefix.add(path + "[" + i + "]");
            }
        }
    }

    public String _visitPathComponent(SimpleParserParser.PathComponentContext ctx) {
        if (ctx.identifier() != null) {
            return _visitIdentifier(ctx.identifier());
        } else if (ctx.arrayAccess() != null) {
            return _visitArrayAccess(ctx.arrayAccess());
        }
        return null;
    }

    public String _visitArrayAccess(SimpleParserParser.ArrayAccessContext ctx) {
        String identifier = _visitIdentifier(ctx.identifier());
        String filter = _visitFilterExpression(ctx.filterExpression());
        if (isNumber(filter)) {
            return identifier + "[" + filter + "]";
        } else if (filter.equals("*")) {
            return identifier;
        } else {
            return identifier + ".?" + "[" + filter + "]";
        }
    }

    private boolean isNumber(String x) {
        try {
            NumberUtils.parseNumber(x, Integer.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String _visitFilterExpression(SimpleParserParser.FilterExpressionContext ctx) {
        if (ctx.simpleFilter() != null) {
            return _visitSimpleFilter(ctx.simpleFilter());
        } else if (ctx.numberFilter() != null) {
            return _visitNumberFilter(ctx.numberFilter());
        } else if (ctx.wildcardFilter() != null) {
            return _visitWildcardFilter(ctx.wildcardFilter());
        } else if (ctx.functionCall() != null) {
            return _visitFunctionCall(ctx.functionCall());
        } else if (ctx.logicalExpression() != null) {
            return _visitLogicalExpression(ctx.logicalExpression());
        }
        return null;
    }

    private String _visitNumberFilter(SimpleParserParser.NumberFilterContext ctx) {
        return ctx.getText();
    }

    private String _visitWildcardFilter(SimpleParserParser.WildcardFilterContext ctx) {
        return ctx.getText();
    }

    public String _visitSimpleFilter(SimpleParserParser.SimpleFilterContext ctx) {
        String identifier = _visitIdentifier(ctx.identifier());
        String literal = _visitLiteral(ctx.literal());
        return identifier + " = " + literal;
    }

    public String _visitLogicalExpression(SimpleParserParser.LogicalExpressionContext ctx) {
        StringBuilder logicalExpr = new StringBuilder();

        // 获取所有条件
        List<SimpleParserParser.ConditionContext> conditions = ctx.condition();
        if (!conditions.isEmpty()) {
            logicalExpr.append(_visitCondition(conditions.get(0))); // 处理第一个条件
        }

        // 遍历逻辑运算符
        for (int i = 0; i < ctx.logicalOperator().size(); i++) {
            logicalExpr.append(' ').append(_visitLogicalOperator(ctx.logicalOperator(i))).append(' '); // 添加运算符
            logicalExpr.append(_visitCondition(conditions.get(i + 1))); // 处理下一个条件
        }

        return logicalExpr.toString();
    }

    public String _visitCondition(SimpleParserParser.ConditionContext ctx) {
        String identifier = _visitIdentifier(ctx.identifier());
        String comparisonOperator = _visitComparisonOperator(ctx.comparisonOperator());
        String operand = ctx.literal() != null ? _visitLiteral(ctx.literal())
                : StringUtils.collectionToDelimitedString(visitExpression(ctx.expression()), ", ");
        return identifier + " " + comparisonOperator + " " + operand;
    }

    public String _visitFunctionCall(SimpleParserParser.FunctionCallContext ctx) {
        String identifier = "#" + _visitIdentifier(ctx.identifier());
        StringBuilder args = new StringBuilder();
        for (SimpleParserParser.FunctionArgContext arg : ctx.functionArgs().functionArg()) {
            if (!args.isEmpty()) {
                args.append(", ");
            }
            args.append(_visitFunctionArg(arg));
        }
        return identifier + "(" + args + ")";
    }

    public String _visitFunctionArgs(SimpleParserParser.FunctionArgsContext ctx) {
        List<SimpleParserParser.FunctionArgContext> args = ctx.functionArg();
        List<String> argStrings = new ArrayList<>();
        for (SimpleParserParser.FunctionArgContext arg : args) {
            argStrings.add(_visitFunctionArg(arg));
        }
        return String.join(", ", argStrings);
    }

    public String _visitFunctionArg(SimpleParserParser.FunctionArgContext ctx) {
        if (ctx.literal() != null) {
            return _visitLiteral(ctx.literal());
        } else if (ctx.pathExpression() != null) {
            List<String> args = visitPathExpression(ctx.pathExpression());
            return StringUtils.collectionToDelimitedString(args, ", ");
        }
        return null;
    }

    public String _visitLiteral(SimpleParserParser.LiteralContext ctx) {
        if (ctx.stringLiteral() != null) {
            return _visitStringLiteral(ctx.stringLiteral());
        } else if (ctx.numberLiteral() != null) {
            return _visitNumberLiteral(ctx.numberLiteral());
        }
        return "";
    }

    public String _visitStringLiteral(SimpleParserParser.StringLiteralContext ctx) {
        return ctx.getText();
    }

    public String _visitNumberLiteral(SimpleParserParser.NumberLiteralContext ctx) {
        return ctx.getText();
    }

    public String _visitLogicalOperator(SimpleParserParser.LogicalOperatorContext ctx) {
        if (ctx.getText().equals("and")) {
            return "&&";
        } else {
            return "||";
        }
    }

    public String _visitComparisonOperator(SimpleParserParser.ComparisonOperatorContext ctx) {
        if (ctx.getText().equals("=")) {
            return "==";
        }
        return ctx.getText();
    }

    public String _visitIdentifier(SimpleParserParser.IdentifierContext ctx) {
        return ctx.getText();
    }
}
