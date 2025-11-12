parser grammar ParseRules;

tokens {
 ASSIGN, BLOCK_START, BLOCK_END, DATA_PIPE, LIST_START, LIST_END, SEQUENCE_RANGE, STRING_START, STRING_END, GROUP_START, GROUP_END, OP_ARITH, LIT_TRUE, LIT_FALSE, OP_LOGIC, OP_STR, FUNC_DEF, FUNC_CALL, RETURN, PRINT, INPUT, IF, ELSE, LOOP, REV, COMMENT, ID, LIT_NUM, LIT_STR, NOT, COMMA
}

// --- Program Structure ---
prog
  : stat prog #RegularProg
  | EOF       #EmptyProg
  ;

block
  : BLOCK_START stat* BLOCK_END #CodeBlock
  ;

// --- Statements (stat) ---
stat
  : ID ASSIGN expr                 #AssignmentStat
  | RETURN ASSIGN expr             #ReturnStat
  | PRINT expr                     #PrintStat
  | INPUT ID                       #InputStat
  | IF GROUP_START expr GROUP_END block (ELSE block)? #IfElseStat
  | LOOP GROUP_START expr GROUP_END block            #LoopStat
  | expr                               #ExprStat
  ;

// --- Lists and Function Components ---
param_list
  : ID (COMMA ID)* #ParamList
  ;

expr_list
  : expr (COMMA expr)* #ExprList
  ;

list_structure
  : LIST_START expr_list? LIST_END     #ListStructure
  ;

// --- Functions ---
func_def
  : FUNC_DEF GROUP_START param_list? GROUP_END block #FunctionDefinition
  ;

func_call
  : FUNC_CALL expr GROUP_START expr_list? GROUP_END #FunctionInvocation
  ;

// --- Expressions (expr) - Corrected for Left-Recursion ---
expr
  : expr DATA_PIPE expr                   #PipeExpr
  | expr SEQUENCE_RANGE expr              #SequenceExpr
  | expr OP_LOGIC expr                    #LogicalORExpr
  | expr OP_LOGIC expr                    #LogicalANDExpr
  | expr OP_STR expr                      #ConcatenateExpr
  | expr OP_STR expr                      #RelationalExpr
  | expr OP_ARITH expr                    #AdditiveExpr
  | expr OP_ARITH expr                    #MultiplicativeExpr
  | expr OP_ARITH expr                    #ExponentiationExpr
  | REV expr                              #UnaryReverseExpr
  | NOT expr                              #LogicalNOTExpr
  | primary_expr                          #PrimaryExpr
  ;

primary_expr
  : LIT_NUM                               #LiteralNum
  | LIT_STR                               #LiteralString
  | LIT_TRUE                              #LiteralTrue
  | LIT_FALSE                             #LiteralFalse
  | ID                                    #VariableRef
  | list_structure                        #ListStructureExpr
  | func_def                              #FunctionDefinitionExpr
  | func_call                             #FunctionCallExpr
  | GROUP_START expr GROUP_END            #ParenthesizedExpr
  ;