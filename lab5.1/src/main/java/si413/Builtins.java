package si413;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

public class Builtins {

    
    // Helper to get the actual java String from a Value, with argument count check.
    public static String getStringArg(List<Value> args, int index, String funcName) {
        if (args.size() <= index) {
            Errors.error(String.format("Built-in '%s' missing argument at position %d.", funcName, index + 1));
        }
        // Safely extract the String value. This relies on Value.str() error checking.
        return args.get(index).str();
    }

    // get string argument, read from filename, and return
    public static Value read(List<Value> args) {
        if (args.size() != 1) {
            Errors.error("read() requires exactly 1 argument (filename string).");
        }
        String fname = getStringArg(args, 0, "read");
        
        try {
            // Reads the entire file content
            String content = Files.readString(Paths.get(fname));
            return new Value.Str(content);
        } catch (IOException e) {
            // Handle file not found or permission errors gracefully
            Errors.error(String.format("File read error for '%s': %s", fname, e.getMessage()));
            return null; // Unreachable
        }
    }

    public static Value plus(List<Value> args) {
        if (args.size() != 2) {
            Errors.error("plus() requires exactly 2 arguments.");
        }
        
        String num1 = getStringArg(args, 0, "plus");
        String num2 = getStringArg(args, 1, "plus");

        try {
            // FIX: Use Long for standard integer size, avoiding BigInteger
            long val1 = Long.parseLong(num1);
            long val2 = Long.parseLong(num2);
            
            // Perform addition and return the result as a string
            String sum = String.valueOf(val1 + val2); 
            return new Value.Str(sum);
        } catch (NumberFormatException e) {
            Errors.error("plus() arguments must be valid integer strings that fit within a 64-bit signed long.");
            return null; // Unreachable
        }
    }
}