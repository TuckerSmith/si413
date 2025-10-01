// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParseRules}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParseRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code RegularProgram}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularProgram(ParseRules.RegularProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyProgram}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyProgram(ParseRules.EmptyProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStatement}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(ParseRules.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(ParseRules.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReverseNotExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverseNotExpr(ParseRules.ReverseNotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(ParseRules.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteralExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteralExpr(ParseRules.BooleanLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(ParseRules.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOpExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOpExpr(ParseRules.BinaryOpExprContext ctx);
}