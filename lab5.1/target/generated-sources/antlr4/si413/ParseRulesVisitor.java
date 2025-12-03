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
	 * Visit a parse tree produced by the {@code RegularProg}
	 * labeled alternative in {@link ParseRules#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularProg(ParseRules.RegularProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyProg}
	 * labeled alternative in {@link ParseRules#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyProg(ParseRules.EmptyProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDStat(ParseRules.IDStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IFStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIFStat(ParseRules.IFStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHILEStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHILEStat(ParseRules.WHILEStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCStat(ParseRules.FUNCStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCVOIDStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCVOIDStat(ParseRules.FUNCVOIDStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCcallVoidStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCcallVoidStat(ParseRules.FUNCcallVoidStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCcallStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCcallStat(ParseRules.FUNCcallStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(ParseRules.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgArg}
	 * labeled alternative in {@link ParseRules#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgArg(ParseRules.ArgArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgRepeat}
	 * labeled alternative in {@link ParseRules#argumentsRepeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgRepeat(ParseRules.ArgRepeatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Emptyargument}
	 * labeled alternative in {@link ParseRules#argumentsRepeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyargument(ParseRules.EmptyargumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LRBracket}
	 * labeled alternative in {@link ParseRules#bracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLRBracket(ParseRules.LRBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InnerInner}
	 * labeled alternative in {@link ParseRules#inner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerInner(ParseRules.InnerInnerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyInner}
	 * labeled alternative in {@link ParseRules#inner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyInner(ParseRules.EmptyInnerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RevExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevExpr(ParseRules.RevExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDExpr(ParseRules.IDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolLitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLitExpr(ParseRules.BoolLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConcatExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatExpr(ParseRules.ConcatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDLRVoidExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDLRVoidExpr(ParseRules.IDLRVoidExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDLRExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDLRExpr(ParseRules.IDLRExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitExpr(ParseRules.LitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InputExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpr(ParseRules.InputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(ParseRules.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ParseRules.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(ParseRules.OpExprContext ctx);
}