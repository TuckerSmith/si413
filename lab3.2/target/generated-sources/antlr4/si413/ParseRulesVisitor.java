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
	 * Visit a parse tree produced by {@link ParseRules#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ParseRules.BlockContext ctx);
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
	 * Visit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(ParseRules.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStat(ParseRules.IfElseStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(ParseRules.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(ParseRules.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReverseString}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverseString(ParseRules.ReverseStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Input}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(ParseRules.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrVarLookup}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrVarLookup(ParseRules.StrVarLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Reverse}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverse(ParseRules.ReverseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ParseRules.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(ParseRules.LitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotOp}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOp(ParseRules.NotOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolVarLookup}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVarLookup(ParseRules.BoolVarLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(ParseRules.BinaryOpContext ctx);
}