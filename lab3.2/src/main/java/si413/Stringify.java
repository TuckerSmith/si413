// Stringify.java
package si413;

/** AST node to convert a Boolean expression (1 or 0) into a String expression ("1" or "0").
 * This is used for concatenation (+) and printing (chat).
 */
public record Stringify(Expr<Boolean> child) implements Expr<String> {
    @Override
    public String eval(Interpreter interp) {
        // Interpreter logic remains the same
        if (child.eval(interp)) return "1";
        else return "0";
    }

    @Override
    public String compile(Compiler comp) {
        // 1. Compile the child Boolean expression. Result is an i1 register.
        String chreg = child.compile(comp);
        
        // 2. Allocate a new register for the resulting String pointer.
        String res = comp.nextRegister();
        
        // 3. Call the runtime function to convert the i1 to a String pointer (ptr).
        // Assumes a runtime function named @bool_to_string exists.
        // It takes the i1 register (chreg) and returns a ptr (String*).
        comp.dest().format("  %s = call i8* @bool_to_string(i1 %s)\n", res, chreg);
        
        // 4. Return the register holding the resulting String pointer.
        return res;
    }
}