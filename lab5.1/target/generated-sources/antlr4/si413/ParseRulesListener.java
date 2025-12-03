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
	 * Enter a parse tree produced by the {@code IDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterIDStat(ParseRules.IDStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitIDStat(ParseRules.IDStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IFStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterIFStat(ParseRules.IFStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IFStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitIFStat(ParseRules.IFStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WHILEStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterWHILEStat(ParseRules.WHILEStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WHILEStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitWHILEStat(ParseRules.WHILEStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterFUNCStat(ParseRules.FUNCStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitFUNCStat(ParseRules.FUNCStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCVOIDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterFUNCVOIDStat(ParseRules.FUNCVOIDStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCVOIDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitFUNCVOIDStat(ParseRules.FUNCVOIDStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCcallVoidStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterFUNCcallVoidStat(ParseRules.FUNCcallVoidStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCcallVoidStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitFUNCcallVoidStat(ParseRules.FUNCcallVoidStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCcallStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterFUNCcallStat(ParseRules.FUNCcallStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCcallStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitFUNCcallStat(ParseRules.FUNCcallStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(ParseRules.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(ParseRules.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgArg}
	 * labeled alternative in {@link ParseRules#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArgArg(ParseRules.ArgArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgArg}
	 * labeled alternative in {@link ParseRules#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArgArg(ParseRules.ArgArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgRepeat}
	 * labeled alternative in {@link ParseRules#argumentsRepeat}.
	 * @param ctx the parse tree
	 */
	void enterArgRepeat(ParseRules.ArgRepeatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgRepeat}
	 * labeled alternative in {@link ParseRules#argumentsRepeat}.
	 * @param ctx the parse tree
	 */
	void exitArgRepeat(ParseRules.ArgRepeatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Emptyargument}
	 * labeled alternative in {@link ParseRules#argumentsRepeat}.
	 * @param ctx the parse tree
	 */
	void enterEmptyargument(ParseRules.EmptyargumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Emptyargument}
	 * labeled alternative in {@link ParseRules#argumentsRepeat}.
	 * @param ctx the parse tree
	 */
	void exitEmptyargument(ParseRules.EmptyargumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LRBracket}
	 * labeled alternative in {@link ParseRules#bracket}.
	 * @param ctx the parse tree
	 */
	void enterLRBracket(ParseRules.LRBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LRBracket}
	 * labeled alternative in {@link ParseRules#bracket}.
	 * @param ctx the parse tree
	 */
	void exitLRBracket(ParseRules.LRBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InnerInner}
	 * labeled alternative in {@link ParseRules#inner}.
	 * @param ctx the parse tree
	 */
	void enterInnerInner(ParseRules.InnerInnerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InnerInner}
	 * labeled alternative in {@link ParseRules#inner}.
	 * @param ctx the parse tree
	 */
	void exitInnerInner(ParseRules.InnerInnerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyInner}
	 * labeled alternative in {@link ParseRules#inner}.
	 * @param ctx the parse tree
	 */
	void enterEmptyInner(ParseRules.EmptyInnerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyInner}
	 * labeled alternative in {@link ParseRules#inner}.
	 * @param ctx the parse tree
	 */
	void exitEmptyInner(ParseRules.EmptyInnerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RevExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterRevExpr(ParseRules.RevExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RevExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitRevExpr(ParseRules.RevExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDExpr(ParseRules.IDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDExpr(ParseRules.IDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolLitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolLitExpr(ParseRules.BoolLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolLitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolLitExpr(ParseRules.BoolLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcatExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterConcatExpr(ParseRules.ConcatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcatExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitConcatExpr(ParseRules.ConcatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDLRVoidExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDLRVoidExpr(ParseRules.IDLRVoidExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDLRVoidExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDLRVoidExpr(ParseRules.IDLRVoidExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDLRExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDLRExpr(ParseRules.IDLRExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDLRExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDLRExpr(ParseRules.IDLRExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLitExpr(ParseRules.LitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLitExpr(ParseRules.LitExprContext ctx);
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
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(ParseRules.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(ParseRules.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(ParseRules.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(ParseRules.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(ParseRules.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(ParseRules.OpExprContext ctx);
}