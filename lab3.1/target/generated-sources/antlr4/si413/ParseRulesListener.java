// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParseRules}.
 */
public interface ParseRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code RegularProg}
	 * labeled alternative in {@link ParseRules#prog}.
	 * @param ctx the parse tree
	 */
	void enterRegularProg(ParseRules.RegularProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RegularProg}
	 * labeled alternative in {@link ParseRules#prog}.
	 * @param ctx the parse tree
	 */
	void exitRegularProg(ParseRules.RegularProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#prog}.
	 * @param ctx the parse tree
	 */
	void enterEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#prog}.
	 * @param ctx the parse tree
	 */
	void exitEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(ParseRules.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(ParseRules.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Input}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterInput(ParseRules.InputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Input}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitInput(ParseRules.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Reverse}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterReverse(ParseRules.ReverseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Reverse}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitReverse(ParseRules.ReverseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(ParseRules.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(ParseRules.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(ParseRules.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(ParseRules.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLit(ParseRules.LitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLit(ParseRules.LitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(ParseRules.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(ParseRules.BinaryOpContext ctx);
}