grammar ParseRules;

// --- Parser Rules ---
// Define a 'tokens' block to explicitly list the tokens that the parser will use.
// These tokens correspond to the names defined in tokenSpec.txt.
tokens {
    TILDE,
    OP_LT, OP_GT, OP_SUB, OP_ADD, OP_AND, OP_OR,
    BOOL,
    PRINT,
    INPUT,
    REV,
    LIT,
    ID
}

// The main entry point of the grammar, representing a program.
program
    : stat program
    | /* epsilon, which means an empty program is valid */
    ;

// Defines a single statement, either a print or an assignment.
stat
    : PRINT expr
    | ID TILDE expr
    ;

// Defines an expression with proper operator precedence.
// AND/OR have the lowest precedence.
expr
    : and_or_expr
    ;

and_or_expr
    : and_or_expr (OP_AND | OP_OR) comp_expr
    | comp_expr
    ;

// Comparison operators and addition have the next precedence level.
comp_expr
    : comp_expr (OP_LT | OP_GT | OP_SUB | OP_ADD) rev_expr
    | rev_expr
    ;

// Reverse operator has the next precedence level.
rev_expr
    : REV TILDE rev_expr TILDE
    | primary_expr
    ;

// Primary expressions are the highest precedence.
primary_expr
    : LIT
    | BOOL
    | INPUT
    | ID
    | '(' expr ')' // Allows for explicit grouping with parentheses
    ;