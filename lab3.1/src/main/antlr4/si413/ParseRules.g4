parser grammar ParseRules;

tokens {
  YAY, OP, BOOL, PRINT, INPUT, REV, LIT, ID, IF, ELSE, WHILE, IS, NOT
}

// block -> stat*
block
    : stat*
    ;

// prog -> stat prog | EOF (ε)
prog
  : stat prog  #RegularProg
  | EOF        #EmptyProg
  ;

// stat -> PRINT expr | ID YAY expr | IF expr YAY block YAY | IF expr YAY block YAY ELSE YAY block YAY | WHILE expr YAY block YAY
stat
  : PRINT expr                                #PrintStat
  | ID YAY expr                               #AssignStat
  | IF expr YAY block YAY ELSE YAY block YAY    #IfElseStat
  | IF expr YAY block YAY                      #IfStat
  | WHILE expr YAY block YAY                   #WhileStat
  ;

// expr -> LIT | BOOL | expr OP expr | INPUT | REV YAY expr YAY | ID | IS ID | NOT YAY expr YAY | REV YAY expr YAY
// ANTLR preference rules are used here to handle the ambiguous `expr OP expr`
// txtlng's operators have a low precedence, so they are grouped together.
expr
  : IS ID                                       #BoolVarLookup
  | ID                                          #StrVarLookup 
  | NOT YAY expr YAY                            #NotOp
  | REV YAY expr YAY                            #ReverseString
  | LIT                                         #Lit
  | BOOL                                        #Bool
  | INPUT                                       #Input
  | REV YAY expr YAY                            #Reverse
  | expr OP expr                                #BinaryOp
  ;