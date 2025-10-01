parser grammar ParseRules;
// grammar for the Truffle language

tokens {TILDE, OP, BOOL, PRINT, INPUT, REV, LIT, ID}

program
 : stat program #RegularProgram
 | EOF #EmptyProgram
 ;

stat
 : PRINT expr #PrintStatement
 | ID TILDE expr #AssignmentStatement
 ;

expr
 : LIT #LiteralExpr
 | BOOL #BooleanLiteralExpr
 | expr OP expr #BinaryOpExpr
 | INPUT #InputExpr
 | REV TILDE expr TILDE #ReverseNotExpr
 | ID #IdentifierExpr
 ;