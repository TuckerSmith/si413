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
	 * Enter a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link ParseRules#block}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(ParseRules.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link ParseRules#block}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(ParseRules.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStat(ParseRules.AssignmentStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStat(ParseRules.AssignmentStatContext ctx);
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
	 * Enter a parse tree produced by the {@code InputStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterInputStat(ParseRules.InputStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InputStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitInputStat(ParseRules.InputStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStat(ParseRules.IfElseStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStat(ParseRules.IfElseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterLoopStat(ParseRules.LoopStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitLoopStat(ParseRules.LoopStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(ParseRules.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ParseRules#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(ParseRules.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamList}
	 * labeled alternative in {@link ParseRules#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParamList(ParseRules.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamList}
	 * labeled alternative in {@link ParseRules#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParamList(ParseRules.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprList}
	 * labeled alternative in {@link ParseRules#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExprList(ParseRules.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprList}
	 * labeled alternative in {@link ParseRules#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExprList(ParseRules.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListStructure}
	 * labeled alternative in {@link ParseRules#list_structure}.
	 * @param ctx the parse tree
	 */
	void enterListStructure(ParseRules.ListStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListStructure}
	 * labeled alternative in {@link ParseRules#list_structure}.
	 * @param ctx the parse tree
	 */
	void exitListStructure(ParseRules.ListStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefinition}
	 * labeled alternative in {@link ParseRules#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(ParseRules.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefinition}
	 * labeled alternative in {@link ParseRules#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(ParseRules.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionInvocation}
	 * labeled alternative in {@link ParseRules#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(ParseRules.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionInvocation}
	 * labeled alternative in {@link ParseRules#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(ParseRules.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(ParseRules.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(ParseRules.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalANDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalANDExpr(ParseRules.LogicalANDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalANDExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalANDExpr(ParseRules.LogicalANDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(ParseRules.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(ParseRules.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalNOTExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNOTExpr(ParseRules.LogicalNOTExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalNOTExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNOTExpr(ParseRules.LogicalNOTExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExponentiationExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpr(ParseRules.ExponentiationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExponentiationExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpr(ParseRules.ExponentiationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryReverseExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryReverseExpr(ParseRules.UnaryReverseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryReverseExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryReverseExpr(ParseRules.UnaryReverseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PipeExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterPipeExpr(ParseRules.PipeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PipeExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitPipeExpr(ParseRules.PipeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(ParseRules.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(ParseRules.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(ParseRules.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(ParseRules.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalORExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalORExpr(ParseRules.LogicalORExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalORExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalORExpr(ParseRules.LogicalORExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcatenateExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterConcatenateExpr(ParseRules.ConcatenateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcatenateExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitConcatenateExpr(ParseRules.ConcatenateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SequenceExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequenceExpr(ParseRules.SequenceExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SequenceExpr}
	 * labeled alternative in {@link ParseRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequenceExpr(ParseRules.SequenceExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralNum}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralNum(ParseRules.LiteralNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralNum}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralNum(ParseRules.LiteralNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralString(ParseRules.LiteralStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralString(ParseRules.LiteralStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralTrue}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralTrue(ParseRules.LiteralTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralTrue}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralTrue(ParseRules.LiteralTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralFalse}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralFalse(ParseRules.LiteralFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralFalse}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralFalse(ParseRules.LiteralFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableRef}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableRef(ParseRules.VariableRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableRef}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableRef(ParseRules.VariableRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListStructureExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterListStructureExpr(ParseRules.ListStructureExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListStructureExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitListStructureExpr(ParseRules.ListStructureExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefinitionExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinitionExpr(ParseRules.FunctionDefinitionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefinitionExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinitionExpr(ParseRules.FunctionDefinitionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(ParseRules.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(ParseRules.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpr(ParseRules.ParenthesizedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link ParseRules#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpr(ParseRules.ParenthesizedExprContext ctx);
}