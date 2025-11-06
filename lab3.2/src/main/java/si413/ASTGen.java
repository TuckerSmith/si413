package si413;

import java.util.ArrayList;
import java.util.List;

/** This class is used to create the AST from a parse tree.
 * The static method ASTGen.gen(parseTree) is the specific function
 * to perform that conversion.
 */
public class ASTGen {
    /** Turns a parse tree Prog node into a complete AST.
     * This is the main external interface for the ASTGen class.
     */
    public static Stmt.Block gen(ParseRules.ProgContext ptreeRoot) {
        return new ASTGen().progVis.visit(ptreeRoot);
    }

    private class BlockVisitor extends Visitor<Stmt.Block> {
        @Override
        public Stmt.Block visitBlock(ParseRules.BlockContext ctx) {
            // Collects all individual statements found inside the block
            List<Stmt> children = new ArrayList<>();
            for (ParseRules.StatContext statCtx : ctx.stat()) {
                children.add(stmtVis.visit(statCtx));
            }
            return new Stmt.Block(children);
        }
    }
    private class ProgVisitor extends Visitor<Stmt.Block> {
        @Override
        public Stmt.Block visitRegularProg(ParseRules.RegularProgContext ctx) {
            // NOTE: ctx.stmt() is now ctx.stat() as per the new grammar rule name
            Stmt first = stmtVis.visit(ctx.stat());
            Stmt.Block rest = visit(ctx.prog());
            // combine those into a single block AST node
            List<Stmt> children = new ArrayList<>();
            children.add(first);
            children.addAll(rest.children());
            return new Stmt.Block(children);
        }

        @Override
        public Stmt.Block visitEmptyProg(ParseRules.EmptyProgContext ctx) {
            return new Stmt.Block(List.of());
        }
    }


    private class StmtVisitor extends Visitor<Stmt> {
        // Corrected StmtVisitor.visitPrintStat in ASTGen.java
        @Override
        public Stmt visitPrintStat(ParseRules.PrintStatContext ctx) {
            Expr<?> child = exprVis.visit(ctx.expr());
            
            // Expand the set of nodes that are guaranteed to return a Boolean:
            boolean isBoolean = (child instanceof Expr.BoolLit) ||
                                (child instanceof Expr.BoolVar) ||
                                (child instanceof Expr.StrLess) ||
                                (child instanceof Expr.Contains) ||
                                (child instanceof Expr.And) ||
                                (child instanceof Expr.Or) ||
                                (child instanceof Expr.Not);
            
            if (isBoolean) {
                @SuppressWarnings("unchecked")
                Expr<Boolean> boolChild = (Expr<Boolean>) child;
                // FIX: Use the top-level Stringify class (defined in Stringify.java)
                child = new Stringify(boolChild); 
            }
            // Assume all remaining expression types (StringLit, StrVar, Concat, Reverse, Input)
            // are String expressions.
            @SuppressWarnings("unchecked")
            Expr<String> stringChild = (Expr<String>) child;
            
            // The original Stmt.java only has PrintString, so we use it.
            return new Stmt.PrintString(stringChild);
        }

        @Override
        public Stmt visitAssignStat(ParseRules.AssignStatContext ctx) {
            String name = ctx.ID().getText();
            Expr<?> child = exprVis.visit(ctx.expr());
            
            // txtlng is untyped. We guess the variable type based on the assigned expression's static type.
            
            // Check for ALL possible expression nodes that return a Boolean (1 or 0)
            boolean isBoolean = (child instanceof Expr.BoolLit) ||
                                (child instanceof Expr.BoolVar) ||
                                (child instanceof Expr.StrLess) ||   // For '<' and '>'
                                (child instanceof Expr.Contains) ||  // For '?'
                                (child instanceof Expr.And) ||       // For '&'
                                (child instanceof Expr.Or) ||        // For '|'
                                (child instanceof Expr.Not);         // For 'nt !...!'
            
            if (isBoolean) {
                // Assign to the Boolean variable map
                @SuppressWarnings("unchecked")
                Expr<Boolean> boolChild = (Expr<Boolean>) child;
                return new Stmt.AssignBool(name, boolChild);
            } else {
                // Assign to the String variable map (default for LIT, Concat, Reverse, Input)
                @SuppressWarnings("unchecked")
                Expr<String> stringChild = (Expr<String>) child;
                return new Stmt.AssignString(name, stringChild);
            }
        }


        
        @Override
        public Stmt visitIfStat(ParseRules.IfStatContext ctx) {
            @SuppressWarnings("unchecked")
            // get the condition expression
            Expr<Boolean> conditionExpr = (Expr<Boolean>) exprVis.visit(ctx.expr());

            //get the then statement
            Stmt thenBlock = blockVis.visit(ctx.block());

            // get the else statement (An IfStat implies an empty Else block)
            Stmt elseBlock = new Stmt.Block(List.of());

            //return the IfElse AST node, passing the empty block for 'elseBody'
            return new Stmt.IfElse(conditionExpr, thenBlock, elseBlock);
        }
        
        @Override
        public Stmt visitIfElseStat(ParseRules.IfElseStatContext ctx) {
            @SuppressWarnings("unchecked")

            // get the condition expression
            Expr<Boolean> conditionExpr = (Expr<Boolean>) exprVis.visit(ctx.expr());

            // Call the block visitor for the THEN block (index 0)
            Stmt thenBlock = blockVis.visit(ctx.block(0));

            // Call the block visitor for the ELSE block (index 1)
            Stmt elseBlock = blockVis.visit(ctx.block(1));

            return new Stmt.IfElse(conditionExpr, thenBlock, elseBlock);
        }
        
        @Override
        public Stmt visitWhileStat(ParseRules.WhileStatContext ctx) {
            @SuppressWarnings("unchecked")

            // get the condition expression
            Expr<Boolean> conditionExpr = (Expr<Boolean>) exprVis.visit(ctx.expr());

            // get the loop body block
            Stmt bodyBlock = blockVis.visit(ctx.block());

            return new Stmt.While(conditionExpr, bodyBlock);
        }
        /* */
        
    }


    // New single visitor for the single grammar rule 'expr'
    private class ExprVisitor extends Visitor<Expr<?>> {
        // Handles variables used in a string context (e.g., 'chat my_string')
        @Override
        public Expr<?> visitStrVarLookup(ParseRules.StrVarLookupContext ctx) {
            // Generates the AST node that checks the String Map
            return new Expr.StrVar(ctx.ID().getText());
        }

        // Handles variables used in a boolean context (e.g., 'gvn IS my_bool')
        @Override
        public Expr<?> visitBoolVarLookup(ParseRules.BoolVarLookupContext ctx) {
            // Generates the AST node that checks the Boolean Map (THIS FIXES THE ERROR)
            return new Expr.BoolVar(ctx.ID().getText());
        }

        @Override
        public Expr<String> visitLit(ParseRules.LitContext ctx) {
            // Extract the actual string literal, handling the txtlng-specific
            // escaping of $ chars and removal of brackets [].
            StringBuilder sb = new StringBuilder();
            String raw = ctx.LIT().getText();
            // Start at 1 to skip leading '[' and end before trailing ']'
            for (int i = 1; i < raw.length()-1; ++i) {
                char current = raw.charAt(i);
                if (current == '$') {
                    // txtlng escape: consume $ and include the next character
                    if (i + 1 < raw.length() - 1) {
                         i++;
                         current = raw.charAt(i);
                    } else {
                         // Should be handled by regex, but as a fallback
                         Errors.error("Malformed string literal escape near end of token");
                    }
                }
                sb.append(current);
            }
            return new Expr.StringLit(sb.toString());
        }

        @Override
        public Expr<Boolean> visitBool(ParseRules.BoolContext ctx) {
            // '0' is False, '1' is True
            return new Expr.BoolLit(ctx.BOOL().getText().equals("1"));
        }

        @Override
        public Expr<String> visitInput(ParseRules.InputContext ctx) {
            return new Expr.Input();
        }

        // 1. Method for Logical NOT
        @Override
        @SuppressWarnings("unchecked")
        public Expr<Boolean> visitNotOp(ParseRules.NotOpContext ctx) {
            // The expression inside 'nt ! expr !' must be a boolean expression
            Expr<Boolean> child = (Expr<Boolean>) visit(ctx.expr());
            return new Expr.Not(child);
        }

        // 2. Method for String Reversal
        @Override
        @SuppressWarnings("unchecked")
        public Expr<String> visitReverseString(ParseRules.ReverseStringContext ctx) {
            // REV is now guaranteed by the grammar to only operate on string expressions
            Expr<String> child = (Expr<String>) visit(ctx.expr());
            return new Expr.Reverse(child);
        }

        @Override
        @SuppressWarnings("unchecked")
        public Expr<?> visitBinaryOp(ParseRules.BinaryOpContext ctx) {
            Expr<?> lhs = visit(ctx.expr(0));
            Expr<?> rhs = visit(ctx.expr(1));
            String op = ctx.OP().getText();

            switch (op) {
                case "+": // String Concatenation (String return)
                    // Coerce LHS to String if it's a Boolean type (e.g., from a BoolVar lookup)
                    if (lhs instanceof Expr.BoolLit || lhs instanceof Expr.BoolVar) {
                        @SuppressWarnings("unchecked")
                        Expr<Boolean> boolLHS = (Expr<Boolean>) lhs;
                        // FIX: Use the top-level Stringify class
                        lhs = new Stringify(boolLHS); 
                    }
                    // Coerce RHS to String if it's a Boolean type
                    if (rhs instanceof Expr.BoolLit || rhs instanceof Expr.BoolVar) {
                        @SuppressWarnings("unchecked")
                        Expr<Boolean> boolRHS = (Expr<Boolean>) rhs;
                         // FIX: Use the top-level Stringify class
                        rhs = new Stringify(boolRHS);
                    }
                    
                    // Now both sides are guaranteed to be String expressions before the cast
                    @SuppressWarnings("unchecked")
                    Expr<String> concatLHS = (Expr<String>) lhs;
                    @SuppressWarnings("unchecked")
                    Expr<String> concatRHS = (Expr<String>) rhs;
                    return new Expr.Concat(concatLHS, concatRHS);
                    
                case "<": // String Less Than (Boolean return)
                    @SuppressWarnings("unchecked")
                    Expr<String> ltLHS = (Expr<String>) lhs;
                    @SuppressWarnings("unchecked")
                    Expr<String> ltRHS = (Expr<String>) rhs;
                    return new Expr.StrLess(ltLHS, ltRHS);

                case ">": // String Greater Than (Boolean return)
                    // Implemented as ! (LHS < RHS)
                    @SuppressWarnings("unchecked")
                    Expr<String> gtLHS = (Expr<String>) lhs;
                    @SuppressWarnings("unchecked")
                    Expr<String> gtRHS = (Expr<String>) rhs;
                    Expr<Boolean> lessThan = new Expr.StrLess(gtLHS, gtRHS);
                    return new Expr.Not(lessThan);
                    
                case "?": // String Contains (Boolean return)
                    @SuppressWarnings("unchecked")
                    Expr<String> contLHS = (Expr<String>) lhs;
                    @SuppressWarnings("unchecked")
                    Expr<String> contRHS = (Expr<String>) rhs;
                    return new Expr.Contains(contLHS, contRHS);

                case "&": // Boolean AND (Boolean return)
                    @SuppressWarnings("unchecked")
                    Expr<Boolean> andLHS = (Expr<Boolean>) lhs;
                    @SuppressWarnings("unchecked")
                    Expr<Boolean> andRHS = (Expr<Boolean>) rhs;
                    return new Expr.And(andLHS, andRHS);

                case "|": // Boolean OR (Boolean return)
                    @SuppressWarnings("unchecked")
                    Expr<Boolean> orLHS = (Expr<Boolean>) lhs;
                    @SuppressWarnings("unchecked")
                    Expr<Boolean> orRHS = (Expr<Boolean>) rhs;
                    return new Expr.Or(orLHS, orRHS);

                default:
                    return Errors.error(String.format("Invalid operator %s", op));
            }
        }
    }

    private BlockVisitor blockVis = new BlockVisitor();
    private ProgVisitor progVis = new ProgVisitor();
    private StmtVisitor stmtVis = new StmtVisitor();
    private ExprVisitor exprVis = new ExprVisitor(); // Use single expression visitor


    /** Use this as the subclass for the visitor classes.
     * It overrides the default method to alert you if one of the
     * visit methods is missing.
     */
    private static class Visitor<T> extends ParseRulesBaseVisitor<T> {
        // This overrides the default behavior to alert if a visit method is missing.
        @Override
        public T visitChildren(org.antlr.v4.runtime.tree.RuleNode node) {
            return Errors.error(String.format(
                "class %s has no visit method for %s",
                getClass().getSimpleName(),
                node.getClass().getSimpleName()));
        }
    }
}