package si413;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Function;

/** This class is used to create the AST from a parse tree.
 * The static method ASTGen.gen(parseTree) is the specific function
 * to perform that conversion.
 */
public class ASTGen {
    /** Turns a parse tree Prog node into a complete AST.
     * This is the main external interface for the ASTGen class.
     */
    public static Stmt.Block gen(ParseRules.ProgContext parseTree) {
        return new ASTGen().stlVis.visit(parseTree);
        //return null;
    }

    /** Use this as the subclass for the visitor classes.
     * It warns you if one of the visit methods is missing at parse-time.
     */
    private static class Visitor<T> extends ParseRulesBaseVisitor<T> {
        @Override
        public T visitChildren(org.antlr.v4.runtime.tree.RuleNode node) {
            return Errors.error(String.format(
                "class %s has no visit method for %s",
                getClass().getSimpleName(),
                node.getClass().getSimpleName()));
        }
    }

    private class StmtListVisitor extends Visitor<Stmt.Block> {
        @Override
        public Stmt.Block visitRegularProg(ParseRules.RegularProgContext ctx) {
            List<Stmt> children = new ArrayList<>();
            children.add(stVis.visit(ctx.stat()));
            children.addAll(visit(ctx.prog()).children());
            return new Stmt.Block(children);
        }

        @Override
        public Stmt.Block visitEmptyProg(ParseRules.EmptyProgContext ctx) {
            return new Stmt.Block(List.of());
        }

        @Override
        public Stmt.Block visitLRBracket(ParseRules.LRBracketContext ctx) {
            return visit(ctx.inner());
        }

        @Override
        public Stmt.Block visitInnerInner(ParseRules.InnerInnerContext ctx) {
            List<Stmt> children = new ArrayList<>();
            children.add(stVis.visit(ctx.stat()));
            // Assuming visit(ctx.inner()) now returns Stmt.Block
            children.addAll(visit(ctx.inner()).children());
            // Use Stmt.Block instead of Stmt.Inner to satisfy the visitor signature
            return new Stmt.Block(children); 
        }

        @Override
        public Stmt.Block visitEmptyInner(ParseRules.EmptyInnerContext ctx) {
            // Use Stmt.Block instead of Stmt.Inner to satisfy the visitor signature
            return new Stmt.Block(List.of());
        }
    }

    private class StmtVisitor extends Visitor<Stmt> {
        @Override
        public Stmt visitPrintStat(ParseRules.PrintStatContext ctx) {
            return new Stmt.Print(eVis.visit(ctx.expr()));
        }

        @Override
        public Stmt visitIDStat(ParseRules.IDStatContext ctx) {
            if (!ctx.ID(0).getText().equals(ctx.ID(1).getText())) {
                return Errors.error(String.format("ID assignment mismatch: '%s' and '%s'",
                            ctx.ID(0).getText(), ctx.ID(1).getText()));
            }
            else return new Stmt.Assign(ctx.ID(0).getText(), eVis.visit(ctx.expr()));
        }

        @Override
        public Stmt visitIFStat(ParseRules.IFStatContext ctx) {
            return new Stmt.IfElse(
                eVis.visit(ctx.expr()),
                stlVis.visit(ctx.bracket()),
                new Stmt.Block(List.of()));
        }

        @Override
        public Stmt visitWHILEStat(ParseRules.WHILEStatContext ctx) {
            return new Stmt.While(
                eVis.visit(ctx.expr()),
                stlVis.visit(ctx.bracket()));
        }

        
        @Override
        public Stmt visitFUNCStat(ParseRules.FUNCStatContext ctx){
            String name = ctx.ID().getText();

            List<String> params = new ArrayList<>();

            ParseRules.ArgumentsContext args = ctx.arguments();

            if (args != null) {
                // ⬇️ NEW: Cast 'args' to its specific rule alternative to get accessors
                ParseRules.ArgArgContext argArgCtx = (ParseRules.ArgArgContext) args;

                // 1. Get the first parameter (ID)
                // The accessor for the token ID will return a List<TerminalNode> or just TerminalNode
                // Assuming ID() returns a List and we want the first one:
                params.add(argArgCtx.ID().getText()); // ⬅️ FIX: use argArgCtx.ID()
                
                // 2. Loop through the rest of the parameters using the argumentsRepeat rule
                // The accessor for the rule 'argumentsRepeat' is generated on the ArgArgContext
                ParseRules.ArgumentsRepeatContext repeatCtx = argArgCtx.argumentsRepeat(); // ⬅️ FIX: use argArgCtx.argumentsRepeat()
                
                while (repeatCtx instanceof ParseRules.ArgRepeatContext) {
                    // ... (rest of the loop remains the same)
                }
            }
    
            // 3. Get the function body (the 'inner' rule within 'bracket')
            ParseRules.BracketContext bracketCtx = ctx.bracket();

            // Cast the BracketContext to its specific alternative (#LRBracket) 
            // to access the inner() method, which gets the body statements.
            ParseRules.LRBracketContext lrBracketCtx = (ParseRules.LRBracketContext) bracketCtx;

            // Visit the 'inner' rule contained in the LRBracketContext
            ParseRules.InnerContext innerCtx = lrBracketCtx.inner(); 
                
            // Visit the body to get the Inner (a list of statements) AST node
            Stmt.Block bodyBlock = (Stmt.Block) visit(innerCtx);

            Stmt.Inner body = new Stmt.Inner(bodyBlock.children());

            return new Stmt.FUNCStat(name, params, body);
        }

        @Override
        public Stmt visitFUNCVOIDStat(ParseRules.FUNCVOIDStatContext ctx){
            // 1. Get the function name (ID)
            String name = ctx.ID().getText();

            // 2. Get the function body (the 'inner' rule within 'bracket')
            ParseRules.BracketContext bracketCtx = ctx.bracket();
            
            // Cast the BracketContext to its specific rule alternative (#LRBracket) 
            // to access the inner() method, which gets the body statements.
            ParseRules.LRBracketContext lrBracketCtx = (ParseRules.LRBracketContext) bracketCtx;
            
            // Visit the 'inner' rule contained in the LRBracketContext
            ParseRules.InnerContext innerCtx = lrBracketCtx.inner(); 
            
            // Recursively visit the body statements
            Stmt.Block bodyBlock = (Stmt.Block) visit(innerCtx);

            Stmt.Inner body = new Stmt.Inner(bodyBlock.children());
            
            // 3. Construct and return the new AST node
            return new Stmt.FUNCVOIDStat(name, body);
        }

        @Override
        public Stmt visitFUNCcallVoidStat(ParseRules.FUNCcallVoidStatContext ctx) {
            // 1. Get the function name
            String name = ctx.ID().getText();

            // 2. Arguments list is empty
            List<Expr> args = new ArrayList<>();

            // 3. Map to the FunctionCallStmt AST node
            return new Stmt.FunctionCallStmt(name, args);
        }

        @Override
        public Stmt visitFUNCcallStat(ParseRules.FUNCcallStatContext ctx) {
            String name = ctx.ID().getText();
            List<Expr> args = new ArrayList<>();
            ParseRules.ArgumentsContext argsCtx = ctx.arguments();
            
            if (argsCtx != null) {
                ParseRules.ArgArgContext argArgCtx = (ParseRules.ArgArgContext) argsCtx;
                
                // --- ERROR LINE 1 (around line 194 in your file) ---
                // OLD: Expr.Var firstArg = (Expr.Var) visit(argArgCtx.ID());
                
                // FIX: Manually create Expr.Var using the ID token's text
                Expr.Var firstArg = new Expr.Var(argArgCtx.ID().getText()); 
                args.add(firstArg);
                
                // Loop through the rest of the arguments
                ParseRules.ArgumentsRepeatContext repeatCtx = argArgCtx.argumentsRepeat();
                while (repeatCtx instanceof ParseRules.ArgRepeatContext) {
                    ParseRules.ArgRepeatContext argRepeat = (ParseRules.ArgRepeatContext) repeatCtx;
                    
                    // --- ERROR LINE 2 (around line 203 in your file) ---
                    // OLD: Expr.Var nextArg = (Expr.Var) visit(argRepeat.ID());
                    
                    // FIX: Manually create Expr.Var using the ID token's text
                    Expr.Var nextArg = new Expr.Var(argRepeat.ID().getText()); 
                    args.add(nextArg);
                    
                    repeatCtx = argRepeat.argumentsRepeat();
                }
            }
            
            return new Stmt.FunctionCallStmt(name, args);
        }

        @Override
        public Stmt visitReturnStat(ParseRules.ReturnStatContext ctx) {
            // 1. Visit the expression ('expr') to get the AST node for the return value
            Expr resultExpr = (Expr) visit(ctx.expr());

            // 2. Construct and return the new AST node
            // This node represents 'sleep <expr>'
            return new Stmt.ReturnStat(resultExpr);
        }
    }

    private class ExprVisitor extends Visitor<Expr> {
        @Override
        public Expr visitLitExpr(ParseRules.LitExprContext ctx) {
            StringBuilder sb = new StringBuilder();
            String raw = ctx.LIT().getText();
            for (int i = 1; i < raw.length()-1; ++i) {
                sb.append(raw.charAt(i));
            }
            return new Expr.StringLit(sb.toString());
        }

        @Override
        public Expr visitInputExpr(ParseRules.InputExprContext ctx) {
            return new Expr.Input();
        }

        @Override
        public Expr visitRevExpr(ParseRules.RevExprContext ctx) {
            return new Expr.Reverse(visit(ctx.expr()));
        }

        @Override
        public Expr visitIDExpr(ParseRules.IDExprContext ctx) {
            return new Expr.Var(ctx.ID().getText());
        }

        @Override
        public Expr visitBoolLitExpr(ParseRules.BoolLitExprContext ctx) {
            return new Expr.BoolLit(ctx.BOOL().getText().equals("Cooked"));
        }

        @Override
        public Expr visitConcatExpr(ParseRules.ConcatExprContext ctx) {
            return new Expr.Concat(
                visit(ctx.expr(0)),
                visit(ctx.expr(1)));
        }

        @Override
        public Expr visitParenExpr(ParseRules.ParenExprContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Expr visitNotExpr(ParseRules.NotExprContext ctx) {
            return new Expr.Not(visit(ctx.expr()));
        }

        @Override
        public Expr visitOpExpr(ParseRules.OpExprContext ctx) {
            Expr left = visit(ctx.expr(0));
            Expr right = visit(ctx.expr(1));
            String op = ctx.OP().getText();
            if (op.equals("<")) {
                return new Expr.StrLess(left, right);
            }
            else if (op.equals(">")) {
                return new Expr.StrLess(right, left);
            }
            else if (op.equals("?")) {
                return new Expr.Contains(left, right);
            }
            else if (op.equals("&")) {
                return new Expr.And(left, right);
            }
            else if (op.equals("|")) {
                return new Expr.Or(left, right);
            }
            else throw new AssertionError("illegal op; should be unreachable");
        }

        @Override
        public Expr visitIDLRExpr(ParseRules.IDLRExprContext ctx) {
            String name = ctx.ID().getText();
            List<Expr> args = new ArrayList<>();
            ParseRules.ArgumentsContext argsCtx = ctx.arguments();
            
            if (argsCtx != null) {
                ParseRules.ArgArgContext argArgCtx = (ParseRules.ArgArgContext) argsCtx;
                
                // FIX 1: Manually create Expr.Var using the ID token's text
                Expr.Var firstArg = new Expr.Var(argArgCtx.ID().getText());
                args.add(firstArg);
                
                ParseRules.ArgumentsRepeatContext repeatCtx = argArgCtx.argumentsRepeat();
                while (repeatCtx instanceof ParseRules.ArgRepeatContext) {
                    ParseRules.ArgRepeatContext argRepeat = (ParseRules.ArgRepeatContext) repeatCtx;
                    
                    // FIX 2: Manually create Expr.Var using the ID token's text
                    Expr.Var nextArg = new Expr.Var(argRepeat.ID().getText());
                    args.add(nextArg);
                    
                    repeatCtx = argRepeat.argumentsRepeat();
                }
            }

            return new Expr.FunctionCall(name, args);
        }

        @Override
        public Expr visitIDLRVoidExpr(ParseRules.IDLRVoidExprContext ctx) {
            String name = ctx.ID().getText();

            // Arguments list is empty
            List<Expr> args = new ArrayList<>();

            return new Expr.FunctionCall(name, args);
        }
    }

    private StmtListVisitor stlVis = new StmtListVisitor();
    private StmtVisitor stVis = new StmtVisitor();
    private ExprVisitor eVis = new ExprVisitor();
}
