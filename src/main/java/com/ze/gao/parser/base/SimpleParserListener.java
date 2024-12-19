// Generated from /Users/ze.gao/Documents/work/Simple-DSL-Java-Ops-Tool/src/main/java/com/ze/gao/parser/base/SimpleParser.g4 by ANTLR 4.13.2
package com.ze.gao.parser.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParserParser}.
 */
public interface SimpleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleParserParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleParserParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleParserParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleParserParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#leftExpression}.
	 * @param ctx the parse tree
	 */
	void enterLeftExpression(SimpleParserParser.LeftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#leftExpression}.
	 * @param ctx the parse tree
	 */
	void exitLeftExpression(SimpleParserParser.LeftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#rightExpression}.
	 * @param ctx the parse tree
	 */
	void enterRightExpression(SimpleParserParser.RightExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#rightExpression}.
	 * @param ctx the parse tree
	 */
	void exitRightExpression(SimpleParserParser.RightExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleParserParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleParserParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#pathExpression}.
	 * @param ctx the parse tree
	 */
	void enterPathExpression(SimpleParserParser.PathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#pathExpression}.
	 * @param ctx the parse tree
	 */
	void exitPathExpression(SimpleParserParser.PathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#pathComponent}.
	 * @param ctx the parse tree
	 */
	void enterPathComponent(SimpleParserParser.PathComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#pathComponent}.
	 * @param ctx the parse tree
	 */
	void exitPathComponent(SimpleParserParser.PathComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(SimpleParserParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(SimpleParserParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpression(SimpleParserParser.FilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpression(SimpleParserParser.FilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#numberFilter}.
	 * @param ctx the parse tree
	 */
	void enterNumberFilter(SimpleParserParser.NumberFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#numberFilter}.
	 * @param ctx the parse tree
	 */
	void exitNumberFilter(SimpleParserParser.NumberFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#wildcardFilter}.
	 * @param ctx the parse tree
	 */
	void enterWildcardFilter(SimpleParserParser.WildcardFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#wildcardFilter}.
	 * @param ctx the parse tree
	 */
	void exitWildcardFilter(SimpleParserParser.WildcardFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#simpleFilter}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFilter(SimpleParserParser.SimpleFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#simpleFilter}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFilter(SimpleParserParser.SimpleFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(SimpleParserParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(SimpleParserParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(SimpleParserParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(SimpleParserParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(SimpleParserParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(SimpleParserParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SimpleParserParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SimpleParserParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgs(SimpleParserParser.FunctionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgs(SimpleParserParser.FunctionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(SimpleParserParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(SimpleParserParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SimpleParserParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SimpleParserParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SimpleParserParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SimpleParserParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SimpleParserParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SimpleParserParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(SimpleParserParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(SimpleParserParser.NumberLiteralContext ctx);
}