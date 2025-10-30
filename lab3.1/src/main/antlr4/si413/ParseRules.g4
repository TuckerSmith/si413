parser grammar ParseRules;

tokens {
  YAY, OP, BOOL, PRINT, INPUT, REV, LIT, ID, IF, ELSE, WHILE
}

// prog -> stat prog | EOF (ε)
prog
  : stat prog  #RegularProg
  | EOF        #EmptyProg
  ;

// stat -> PRINT expr | ID YAY expr | IF expr YAY stat YAY | IF expr YAY stat YAY ELSE YAY stat YAY | WHILE expr YAY stat YAY
stat
  : PRINT expr                                #PrintStat
  | ID YAY expr                               #AssignStat
  | IF expr YAY stat YAY                      #IfStat
  | IF expr YAY stat YAY ELSE YAY stat YAY    #IfElseStat
  | WHILE expr YAY stat YAY                   #WhileStat
  ;

// expr -> LIT | BOOL | expr OP expr | INPUT | REV YAY expr YAY | ID
// ANTLR preference rules are used here to handle the ambiguous `expr OP expr`
// txtlng's operators have a low precedence, so they are grouped together.
expr
  : ID                                          #Var
  | LIT                                         #Lit
  | BOOL                                        #Bool
  | INPUT                                       #Input
  | REV YAY expr YAY                            #Reverse
  | expr OP expr                                #BinaryOp
  ;