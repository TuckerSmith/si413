// Generated from si413/ParseRules.g4 by ANTLR 4.13.1
package si413;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParseRulesParser}.
 */
public interface ParseRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParseRulesParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ParseRulesParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParseRulesParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ParseRulesParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParseRulesParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ParseRulesParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParseRulesParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ParseRulesParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParseRulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ParseRulesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParseRulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ParseRulesParser.ExprContext ctx);
}