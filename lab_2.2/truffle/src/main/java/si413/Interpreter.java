package si413;

import java.nio.file.Path;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.antlr.v4.runtime.TokenStream;

/** Interpreter for the Truffle language.
 * The tokens and grammar come from src/main/resource/si413/tokenSpec.txt
 * and src/main/antlr4/si413/ParseRules.g4 respectively.
 */
public class Interpreter {
    private Map<String, Object> memory = new HashMap<>();

    /** Methods in this class will execute statements.
     * The return type is Void because statements do not return anything.
     */
    private class StatementVisitor extends ParseRulesBaseVisitor<Void> {
        
        @Override
        public Void visitRegularProgram(ParseRules.RegularProgramContext ctx) {
            // Traverse the statement and then recursively the rest of the program.
            visit(ctx.stat());
            visit(ctx.program());
            return null;
        }
        
        // NEW: Handles 'PRINT expr'
        @Override
        public Void visitPrintStatement(ParseRules.PrintStatementContext ctx) {
            // The ExpressionVisitor evaluates the expression and returns the result.
            Object value = evisitor.visit(ctx.expr());
            System.out.println(value);
            return null;
        }

        // NEW: Handles 'ID TILDE expr' (Assignment)
        @Override
        public Void visitAssignmentStatement(ParseRules.AssignmentStatementContext ctx) {
            // 1. Get the variable name (ID)
            String varName = ctx.ID().getText();
            
            // 2. Evaluate the expression (expr)
            Object value = evisitor.visit(ctx.expr());
            
            // 3. Store the result in memory
            memory.put(varName, value);
            
            return null;
        }
        
        // Note: You may also need to implement visitEmptyProgram here if it's
        // not handled by the default visitor behavior for the 'EOF' case.
    }

    /** Methods in this class will execute expressions and return the result.
     * The return type is Object because Truffle is untyped and expressions can
     * return strings (LIT), booleans (BOOL), or other types.
     */
    private class ExpressionVisitor extends ParseRulesBaseVisitor<Object> {
        
        // Handles 'LIT' from the rule 'expr -> LIT'
        @Override
        public Object visitLiteralExpr(ParseRules.LiteralExprContext ctx) {
            String rawText = ctx.LIT().getText();
            // 1. Strip the outer brackets: "[...]" -> "..."
            if (rawText.length() < 2) return ""; 
            String innerText = rawText.substring(1, rawText.length() - 1);
            
            // 2. Process escape sequences: $[, $], $$, and others (like $ followed by any char)
            // The sequence replacement must be done carefully to prevent double-replacements.
            // Replace the most specific sequences first:
            innerText = innerText.replace("$[", "[");
            innerText = innerText.replace("$]", "]");
            innerText = innerText.replace("$$", "$");
            // Note: The example only shows $ with [, ], and $, but if $ is followed by another
            // character (e.g., $h), it also just means 'h'. Your current regex only allows
            // $[, $], $$, or non-special chars, which simplifies this.
            
            return innerText;
        }
        
        // You will also need to implement this for 'p a' to work later:
        // Handles 'ID' from the rule 'expr -> ID'
        @Override
        public Object visitIdentifierExpr(ParseRules.IdentifierExprContext ctx) {
            String varName = ctx.ID().getText();
            
            // Retrieve the value from the memory map.
            Object value = memory.get(varName);
            
            // Truffle is untyped, so all values are stored and retrieved as Object (String or "0"/"1").
            
            if (value == null) {
                Errors.error("Runtime Error: Variable '" + varName + "' used before assignment.");
                return null; 
            }
            
            return value;
        }
        
        // You'll need other expression handlers later:
        // - visitBooleanLiteralExpr
        @Override
        public Object visitBooleanLiteralExpr(ParseRules.BooleanLiteralExprContext ctx) {
            // The BOOL token's text is already "0" or "1".
            // We can return the String representation directly, as Truffle is untyped.
            return ctx.BOOL().getText();
        }

        // - visitBinaryOpExpr
        @Override
        public Object visitBinaryOpExpr(ParseRules.BinaryOpExprContext ctx) {
            // 1. Evaluate both sides of the expression
            Object left = visit(ctx.expr(0));
            Object right = visit(ctx.expr(1));
            
            // NOTE: If an inner expression like an ID (variable) was uninitialized,
            // the call to visit() for that expression should have already called 
            // Errors.error() and halted the program via your visitIdentifierExpr implementation.
            // However, a secondary check for null here ensures safety if the Errors.error() 
            // implementation allows the program flow to continue temporarily.
            
            if (left == null || right == null) {
                // Since visitIdentifierExpr *should* have already thrown an error, 
                // we'll explicitly check the operands here. If either is null, something 
                // went wrong (likely an uninitialized variable), and we must halt.
                // We'll call Errors.error() here as a safeguard, referencing the operator.
                String op = ctx.OP().getText();
                Errors.error("Runtime Error: Cannot apply operator '" + op + "' to an undefined value.");
                return null; // Return null as a placeholder, though Errors.error() should terminate.
            }

            // 2. Get the operator text
            String op = ctx.OP().getText();
            
            // 3. Dispatch based on the operator
            switch (op) {
                // Boolean Operations (Expects "0" or "1" strings)
                case "&":
                case "|":
                    return handleBooleanOp(left, right, op);
                    
                // String Operations (Expects String values)
                case "<":
                case ">":
                case "?":
                case "+":
                    return handleStringOp(left, right, op);

                default:
                    // This should be a parsing error, but check here just in case.
                    Errors.error("Runtime Error: Unknown operator " + op);
                    return null; 
            }
        }
        
        // Inside Interpreter class (as a private method) or ExpressionVisitor (if you prefer)
        private Object handleBooleanOp(Object left, Object right, String op) {
            // Ensure both operands are strings "0" or "1"
            String sLeft = left.toString();
            String sRight = right.toString();

            // Convert to actual booleans (true for "1", false for "0")
            boolean bLeft = sLeft.equals("1");
            boolean bRight = sRight.equals("1");

            boolean result;
            switch (op) {
                case "&":
                    result = bLeft && bRight;
                    break;
                case "|":
                    result = bLeft || bRight;
                    break;
                default:
                    throw new RuntimeException("Internal Error: Invalid boolean operator.");
            }
            
            // Return the result as the Truffle boolean string "1" or "0"
            return result ? "1" : "0";
        }
        // Inside Interpreter class (as a private method) or ExpressionVisitor
        private Object handleStringOp(Object left, Object right, String op) {
            // Truffle's untyped nature means we rely on the input being a string here.
            String sLeft = left.toString();
            String sRight = right.toString();

            switch (op) {
                // Concatenation
                case "+":
                    return sLeft + sRight;

                // Substring check (returns "1" or "0")
                case "?":
                    // ? checks if the string on the left is a substring of the string on the right.
                    boolean contains = sRight.contains(sLeft);
                    return contains ? "1" : "0";

                // Lexicographical comparison (returns "1" or "0")
                case "<":
                    // String.compareTo returns: < 0 if sLeft < sRight
                    int lessThan = sLeft.compareTo(sRight);
                    return (lessThan < 0) ? "1" : "0";
                    
                case ">":
                    // String.compareTo returns: > 0 if sLeft > sRight
                    int greaterThan = sLeft.compareTo(sRight);
                    return (greaterThan > 0) ? "1" : "0";
                    
                default:
                    throw new RuntimeException("Internal Error: Invalid string operator.");
            }
        }
        // - visitInputExpr
        @Override
        public Object visitInputExpr(ParseRules.InputExprContext ctx) {
            // Read the next complete line of input from the Scanner
            if (stdin.hasNextLine()) {
                return stdin.nextLine();
            } else {
                // If there's no more input, the behavior is undefined.
                // Returning an empty string or throwing an error are common choices.
                System.err.println("Runtime Warning: Attempted to read input past end-of-file. Returning empty string.");
                return "";
            }
        }
        // - visitReverseNotExpr
        @Override
        public Object visitReverseNotExpr(ParseRules.ReverseNotExprContext ctx) {
            // 1. Evaluate the inner expression (the one between the two TILDEs)
            Object value = visit(ctx.expr());
            
            if (value == null) {
                // Handle case where inner expression evaluation failed (e.g., undefined variable)
                return null; 
            }
            
            String sValue = value.toString();

            // 2. Determine the operation based on the content (type) of the inner expression.
            if (sValue.equals("0") || sValue.equals("1")) {
                // It's a boolean expression: perform logical NOT
                return handleLogicalNot(sValue);
            } else {
                // It's a string expression: perform string reversal
                return handleStringReverse(sValue);
            }
        }
    }

    // You can put this as a private method inside ExpressionVisitor or Interpreter
    private Object handleLogicalNot(String boolString) {
        // r followed by a boolean expression enclosed in ~ returns the logical NOT of the expression
        if (boolString.equals("1")) {
            return "0";
        } else if (boolString.equals("0")) {
            return "1";
        }
        // Should not happen if expression evaluation is correct
        throw new RuntimeException("Runtime Error: Expected boolean ('0' or '1') for NOT operation, got: " + boolString);
    }

    // You can put this as a private method inside ExpressionVisitor or Interpreter
    private Object handleStringReverse(String str) {
        // r followed by a string expression enclosed in ~ returns the expression in reverse order
        return new StringBuilder(str).reverse().toString();
    }

    // You will need to replace or update these fields for Truffle's requirements
    // For example, a map for variable storage, and the Scanner for input.
    private Scanner stdin = new Scanner(System.in);
    
    // Instantiate the visitors
    private StatementVisitor svisitor = new StatementVisitor();
    private ExpressionVisitor evisitor = new ExpressionVisitor();
    
    // Assuming Tokenizer and Errors classes exist and are correct
    private Tokenizer tokenizer;

    public Interpreter() throws IOException {
        // NOTE: Ensure your tokenizer input file path is correct here
        this.tokenizer = new Tokenizer(
            getClass().getResourceAsStream("tokenSpec.txt"),
            ParseRules.VOCABULARY
        );
    }

    // Changed return type from ParseRules.ProgContext to ParseRules.ProgramContext
    // based on your new 'program' rule in ParseRules.g4
    public ParseRules.ProgramContext parse(Path sourceFile) throws IOException {
        TokenStream tokenStream = tokenizer.streamFrom(sourceFile);
        ParseRules parser = new ParseRules(tokenStream);
        Errors.register(parser);
        return parser.program(); // Call the 'program' rule
    }

    // Changed parameter type from ParseRules.ProgContext to ParseRules.ProgramContext
    public void execute(ParseRules.ProgramContext parseTree) {
        // to execute the whole program, we just call visit() on the root
        // node of the parse tree!
        svisitor.visit(parseTree);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            Errors.error("need 1 command-line arg: input source file");
        }
        Path sourceFile = Path.of(args[0]);
        Interpreter interp = new Interpreter();
        // Changed variable type
        ParseRules.ProgramContext parseTree = interp.parse(sourceFile);
        interp.execute(parseTree);
    }
}