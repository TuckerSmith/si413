parser grammar ParseRules;

tokens {
  TILDE, OP, BOOL, PRINT, INPUT, REV, LIT, ID
}

// prog -> stat prog | EOF (ε)
prog
  : stat prog  #RegularProg
  | EOF        #EmptyProg
  ;

// stat -> PRINT expr | ID TILDE expr
stat
  : PRINT expr               #PrintStat
  | ID TILDE expr            #AssignStat
  ;

// expr -> LIT | BOOL | expr OP expr | INPUT | REV TILDE expr TILDE | ID
// ANTLR preference rules are used here to handle the ambiguous `expr OP expr`
// Truffle's operators have a low precedence, so they are grouped together.
expr
  : ID                                         #Var
  | LIT                                        #Lit
  | BOOL                                       #Bool
  | INPUT                                      #Input
  | REV TILDE expr TILDE                       #Reverse
  | expr OP expr                               #BinaryOp
  ;