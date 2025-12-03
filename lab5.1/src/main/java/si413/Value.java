package si413;
import java.util.List;
import java.util.function.Function;
import si413.Frame;

/** Holds a generic Value that can be either a string or a boolean.
 * To make a string, create an instance of Value.Str("like this").
 * To make a bool, create an instance of Value.Bool(true||false)
 * To convert a Value object to an actual String or bool, call str() or bool().
 */
public interface Value {
    default String str() {
        return Errors.error(String.format("Value type error: Expected string, got %s", toString()));
    }

    default boolean bool() {
        return Errors.error(String.format("Value type error: Expected boolean, got %s", toString()));
    }

    record Str(String value) implements Value {
        @Override
        public String str() { return value; }

        @Override
        public String toString() { return value; }
    }

    record Bool(Boolean value) implements Value {
        @Override
        public boolean bool() { return value; }

        @Override
        public String str() {
            // FIX: Return the string representation for concatenation/printing
            return toString();
        }

        @Override
        public String toString() {
            return value ? "True" : "False";
        }
    }
    
    record Closure(String name, List<String> params, Stmt.Inner body, Frame env) implements Value {
        
        // Closures can't be automatically converted to strings or booleans, 
        // so they should trigger an error if a user tries to print them directly
        // or use them in a condition.
        @Override
        public String toString() {
            return String.format("<Closure %s with %d params>", name, params.size());
        }
    }

    record Builtin(String name, Function<List<Value>, Value> logic) implements Value {
        @Override
        public String toString() {
            return String.format("<Builtin Function %s>", name);
        }
    }
}