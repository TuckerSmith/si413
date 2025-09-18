/*
 * Changes:
 * - Added a note to the class javadoc about the tokenSpec.txt dependency.
 * - Added new imports for Map and HashMap.
 * - The `visitExpr` method has been refactored. The original flat `if/else if` chain
 * is replaced with a call to `visitChildren(ctx)`, which correctly traverses
 * the new grammar's rule hierarchy.
 * - New visitor methods (`visitAnd_or_expr`, `visitComp_expr`, `visitRev_expr`,
 * and `visitPrimary_expr`) are added to match the updated `ParseRules.g4`
 * grammar. This allows the interpreter to correctly handle operator precedence.
 * - The logic for each operator is moved into its corresponding new visitor method.
 * - The `visitPrimary_expr` method handles the base cases: LIT, BOOL, ID, and INPUT.
 * The `LIT` parsing logic is improved for robustness.
 * - The `parse` method remains the same because it correctly uses the custom tokenizer.
 * - The `execute` method is updated to take the new `ParseRulesParser.ProgramContext` type.
 */
package si413;

import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.BufferedTokenStream;

/** Interpreter for the Truffle language.
 * This interpreter uses a custom tokenizer based on the tokenSpec.txt file
 * and an ANTLR grammar for parsing rules.
 */
public class Interpreter extends ParseRulesBaseVisitor<Object> {

    // Your symbol table for variable storage
    private Map<String, Object> variables = new HashMap<>();
    private Scanner stdin = new Scanner(System.in);
    private Tokenizer tokenizer;

    public Interpreter() throws IOException {
        // Correct path to the token specification file
        this.tokenizer = new Tokenizer(
            getClass().getResourceAsStream("/si413/tokenSpec.txt"),
            ParseRulesParser.VOCABULARY
        );
    }
    
    // The main entry point will be visitProgram.
    @Override
    public Object visitProgram(ParseRulesParser.ProgramContext ctx) {
        if (ctx.stat() != null) {
            visit(ctx.stat());
        }
        if (ctx.program() != null) {
            visit(ctx.program());
        }
        return null;
    }

    //------------------------------------
    // New visitor methods for the updated grammar rules
    //------------------------------------

    @Override
    public Object visitStat(ParseRulesParser.StatContext ctx) {
        // Handle a PRINT statement (p expr)
        if (ctx.PRINT() != null) {
            Object value = visit(ctx.expr());
            System.out.println(value);
        }
        // Handle an assignment statement (ID ~ expr)
        else if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            Object value = visit(ctx.expr());
            variables.put(varName, value);
        }
        return null;
    }

    @Override
    public Object visitExpr(ParseRulesParser.ExprContext ctx) {
        // The expr rule in the new grammar is a hierarchy, so you need to visit
        // the child node, which will be the top-level expression.
        return visitChildren(ctx);
    }

    @Override
    public Object visitAnd_or_expr(ParseRulesParser.And_or_exprContext ctx) {
        if (ctx.and_or_expr() != null) {
            Object left = visit(ctx.and_or_expr());
            Object right = visit(ctx.comp_expr());
            String op = ctx.OP_AND() != null ? ctx.OP_AND().getText() : ctx.OP_OR().getText();

            // Logic for boolean operators
            if (left instanceof Integer && right instanceof Integer) {
                int l = (int) left;
                int r = (int) right;
                switch (op) {
                    case "&":
                        return (l == 1 && r == 1) ? 1 : 0;
                    case "|":
                        return (l == 1 || r == 1) ? 1 : 0;
                }
            }
            throw new RuntimeException("Error: '" + op + "' operator requires two booleans (0 or 1).");
        }
        return visitChildren(ctx);
    }
    
    @Override
    public Object visitComp_expr(ParseRulesParser.Comp_exprContext ctx) {
        if (ctx.comp_expr() != null) {
            Object left = visit(ctx.comp_expr());
            Object right = visit(ctx.rev_expr());
            String op = "";
            if (ctx.OP_LT() != null) op = ctx.OP_LT().getText();
            else if (ctx.OP_GT() != null) op = ctx.OP_GT().getText();
            else if (ctx.OP_SUB() != null) op = ctx.OP_SUB().getText();
            else if (ctx.OP_ADD() != null) op = ctx.OP_ADD().getText();

            // Logic for string operators
            if (left instanceof String && right instanceof String) {
                String l = (String) left;
                String r = (String) right;
                switch (op) {
                    case "<":
                        return (l.length() < r.length()) ? 0 : 1;
                    case ">":
                        return (l.length() > r.length()) ? 0 : 1;
                    case "?":
                        return r.contains(l) ? 0 : 1;
                    case "+":
                        return l + r;
                }
            }
            throw new RuntimeException("Error: '" + op + "' operator requires two strings.");
        }
        return visitChildren(ctx);
    }
    
    @Override
    public Object visitRev_expr(ParseRulesParser.Rev_exprContext ctx) {
        if (ctx.REV() != null) {
            Object value = visit(ctx.rev_expr());
            if (value instanceof String) {
                return new StringBuilder((String) value).reverse().toString();
            } else {
                throw new RuntimeException("Error: 'r~' can only be applied to strings.");
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitPrimary_expr(ParseRulesParser.Primary_exprContext ctx) {
        if (ctx.LIT() != null) {
            String text = ctx.LIT().getText();
            // Remove the leading and trailing brackets
            String content = text.substring(1, text.length() - 1);
            
            // Handle escape sequences: "$$" -> "$", "$[" -> "[", "$]" -> "]"
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < content.length(); i++) {
                char c = content.charAt(i);
                if (c == '$' && i + 1 < content.length()) {
                    char next = content.charAt(i + 1);
                    if (next == '$' || next == '[' || next == ']') {
                        sb.append(next);
                        i++; // Skip the next character
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        
        if (ctx.BOOL() != null) {
            return Integer.parseInt(ctx.BOOL().getText());
        }
        
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            if (variables.containsKey(varName)) {
                return variables.get(varName);
            } else {
                // Use the Errors class to throw a consistent syntax error
                Errors.error("Undefined variable '" + varName + "'");
                return null; // Unreachable
            }
        }
        
        if (ctx.INPUT() != null) {
            System.out.print("> ");
            return stdin.nextLine();
        }
        
        // This handles expressions within parentheses
        return visitChildren(ctx);
    }

    // The rest of the methods remain unchanged as they correctly use the custom tokenizer.
    public ParseRulesParser.ProgramContext parse(Path sourceFile) throws IOException {
        TokenStream tokenStream = tokenizer.streamFrom(sourceFile);
        
        ParseRulesParser parser = new ParseRulesParser(new BufferedTokenStream(tokenStream));
        Errors.register(parser);
        
        return parser.program(); 
    }

    public void execute(ParseRulesParser.ProgramContext parseTree) {
        visit(parseTree);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            Errors.error("need 1 command-line arg: input source file");
        }
        Path sourceFile = Path.of(args[0]);
        Interpreter interp = new Interpreter();
        
        ParseRulesParser.ProgramContext parseTree = interp.parse(sourceFile);
        
        interp.visit(parseTree);
    }
}