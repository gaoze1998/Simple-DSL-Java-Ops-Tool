// Generated from /Users/ze.gao/Documents/work/Simple-DSL-Java-Ops-Tool/src/main/java/com/ze/gao/parser/base/SimpleParser.g4 by ANTLR 4.13.2
package com.ze.gao.parser.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleParserParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SimpleParserParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#leftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftExpression(SimpleParserParser.LeftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#rightExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightExpression(SimpleParserParser.RightExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#pathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathExpression(SimpleParserParser.PathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#pathComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathComponent(SimpleParserParser.PathComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(SimpleParserParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#filterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterExpression(SimpleParserParser.FilterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#numberFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberFilter(SimpleParserParser.NumberFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#wildcardFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardFilter(SimpleParserParser.WildcardFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#simpleFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFilter(SimpleParserParser.SimpleFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(SimpleParserParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(SimpleParserParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(SimpleParserParser.LogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(SimpleParserParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#functionArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgs(SimpleParserParser.FunctionArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#functionArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArg(SimpleParserParser.FunctionArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SimpleParserParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SimpleParserParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SimpleParserParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(SimpleParserParser.NumberLiteralContext ctx);
}