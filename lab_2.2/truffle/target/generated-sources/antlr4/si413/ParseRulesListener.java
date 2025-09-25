// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParseRules}.
 */
public interface ParseRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code RegularProgram}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void enterRegularProgram(ParseRules.RegularProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RegularProgram}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void exitRegularProgram(ParseRules.RegularProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyProgram}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void enterEmptyProgram(ParseRules.EmptyProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyProgram}
	 * labeled alternative in {@link ParseRules#program}.
	 * @param ctx the parse tree
	 */
	void exitEmptyProgram(ParseRules.EmptyProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStatement}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(ParseRules.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStatement}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(ParseRules.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(ParseRules.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(ParseRules.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReverseNotExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterReverseNotExpr(ParseRules.ReverseNotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReverseNotExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitReverseNotExpr(ParseRules.ReverseNotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(ParseRules.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(ParseRules.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteralExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteralExpr(ParseRules.BooleanLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteralExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteralExpr(ParseRules.BooleanLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(ParseRules.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(ParseRules.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOpExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpExpr(ParseRules.BinaryOpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOpExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpExpr(ParseRules.BinaryOpExprContext ctx);
}