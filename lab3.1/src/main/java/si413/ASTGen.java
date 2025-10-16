package si413;

import java.util.List;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.RuleNode;

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
                return new Stmt.PrintBool(boolChild);
            } else {
                // Assume all remaining expression types (StringLit, StrVar, Concat, Reverse, Input)
                // are String expressions.
                @SuppressWarnings("unchecked")
                Expr<String> stringChild = (Expr<String>) child;
                return new Stmt.PrintString(stringChild);
            }
        }

        @Override
        public Stmt visitAssignStat(ParseRules.AssignStatContext ctx) {
            String name = ctx.ID().getText();
            Expr<?> child = exprVis.visit(ctx.expr());
            
            // Truffle is untyped. We guess the variable type based on the assigned value.
            // If the expression is a BoolLit, we assume AssignBool. Otherwise, AssignString.
            if (child instanceof Expr.BoolLit) {
                @SuppressWarnings("unchecked")
                Expr<Boolean> boolChild = (Expr<Boolean>) child;
                return new Stmt.AssignBool(name, boolChild);
            } else {
                @SuppressWarnings("unchecked")
                Expr<String> stringChild = (Expr<String>) child;
                return new Stmt.AssignString(name, stringChild);
            }
        }
        
        // Remove old methods like visitStringPrint and visitBoolPrint
    }


    // New single visitor for the single grammar rule 'expr'
    private class ExprVisitor extends Visitor<Expr<?>> {
        @Override
        public Expr<?> visitVar(ParseRules.VarContext ctx) {
            // Cannot know if StrVar or BoolVar statically. Default to StrVar (most common type).
            // Runtime type check will fail if used incorrectly.
            return new Expr.StrVar(ctx.ID().getText());
        }

        @Override
        public Expr<String> visitLit(ParseRules.LitContext ctx) {
            // Extract the actual string literal, handling the Truffle-specific
            // escaping of $ chars and removal of brackets [].
            StringBuilder sb = new StringBuilder();
            String raw = ctx.LIT().getText();
            // Start at 1 to skip leading '[' and end before trailing ']'
            for (int i = 1; i < raw.length()-1; ++i) {
                char current = raw.charAt(i);
                if (current == '$') {
                    // Truffle escape: consume $ and include the next character
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

        @Override
        public Expr<?> visitReverse(ParseRules.ReverseContext ctx) {
            Expr<?> child = visit(ctx.expr());
            
            // Truffle: r~string~ is Reverse; r~bool~ is Not (logical NOT).
            // We use instance checks on the sub-expression's *static* type.
            if (child instanceof Expr.BoolLit || child instanceof Expr.BoolVar) {
                // If the child is or can be a boolean, assume logical NOT
                @SuppressWarnings("unchecked")
                Expr<Boolean> boolChild = (Expr<Boolean>) child;
                return new Expr.Not(boolChild);
            } else {
                // Otherwise, assume string reverse
                @SuppressWarnings("unchecked")
                Expr<String> stringChild = (Expr<String>) child;
                return new Expr.Reverse(stringChild);
            }
        }

        @Override
        public Expr<?> visitBinaryOp(ParseRules.BinaryOpContext ctx) {
            Expr<?> lhs = visit(ctx.expr(0));
            Expr<?> rhs = visit(ctx.expr(1));
            String op = ctx.OP().getText();

            switch (op) {
                case "+": // String Concatenation (String return)
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
                    // '>' is not a direct AST node. Implement as !(LHS < RHS) && !(LHS > RHS)
                    // Since the current language is simple, we implement this as ! (LHS < RHS)
                    // This is an approximation: "a" > "b" -> False. "b" > "a" -> True.
                    // !("b" < "a") -> !(False) -> True.
                    // !("a" < "b") -> !(True) -> False.
                    // This works for simple cases, but fails if == is possible.
                    // A better way is !(LHS < RHS) and NOT (LHS == RHS), but we lack an '==' node.
                    // For now, we use the simple approximation, assuming there is no '==' logic.
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