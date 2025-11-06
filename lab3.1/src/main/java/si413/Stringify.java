// Stringify.java
package si413;

/** AST node to convert a Boolean expression (1 or 0) into a String expression ("1" or "0").
 * This is used for concatenation (+) and printing (chat).
 */
public record Stringify(Expr<Boolean> child) implements Expr<String> {
    @Override
    public String eval(Interpreter interp) {
        // Returns "1" if True, "0" if False.
        if (child.eval(interp)) return "True";
        else return "False";
    }
}
