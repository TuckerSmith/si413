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
	 * Visit a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link ParseRules#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(ParseRules.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStat(ParseRules.AssignmentStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(ParseRules.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(ParseRules.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InputStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStat(ParseRules.InputStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStat(ParseRules.IfElseStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStat(ParseRules.LoopStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(ParseRules.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamList}
	 * labeled alternative in {@link ParseRules#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(ParseRules.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprList}
	 * labeled alternative in {@link ParseRules#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(ParseRules.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListStructure}
	 * labeled alternative in {@link ParseRules#list_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListStructure(ParseRules.ListStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefinition}
	 * labeled alternative in {@link ParseRules#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(ParseRules.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionInvocation}
	 * labeled alternative in {@link ParseRules#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(ParseRules.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(ParseRules.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalANDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalANDExpr(ParseRules.LogicalANDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(ParseRules.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalNOTExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNOTExpr(ParseRules.LogicalNOTExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExponentiationExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiationExpr(ParseRules.ExponentiationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryReverseExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryReverseExpr(ParseRules.UnaryReverseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PipeExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeExpr(ParseRules.PipeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(ParseRules.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(ParseRules.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalORExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalORExpr(ParseRules.LogicalORExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConcatenateExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenateExpr(ParseRules.ConcatenateExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SequenceExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceExpr(ParseRules.SequenceExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralNum}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralNum(ParseRules.LiteralNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralString(ParseRules.LiteralStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralTrue}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralTrue(ParseRules.LiteralTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralFalse}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralFalse(ParseRules.LiteralFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableRef}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableRef(ParseRules.VariableRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListStructureExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListStructureExpr(ParseRules.ListStructureExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefinitionExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinitionExpr(ParseRules.FunctionDefinitionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(ParseRules.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpr(ParseRules.ParenthesizedExprContext ctx);
}