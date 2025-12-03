package si413;

import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.nio.file.Path;
import java.io.IOException;
import org.antlr.v4.runtime.TokenStream;
import java.util.List;
import java.util.ArrayList;

/** AST-based Interpreter.
 * This class holds variables to manage the state of a running
 * interpreter, such as symbol tables.
 * It also has a main() method to scan, parse, generate the AST,
 * and then execute that AST.
 * YOU WILL NEED TO MAKE SOME CHANGES HERE to support lexical scoping
 * and frames with parents.
 */
public class Interpreter {
    // These objects are used to managed the state of the interpreter
    // as it executes a program.
    private Scanner stdin = new Scanner(System.in);

    private Frame globalFrame;

    private Frame currentEnv;


    
    public Interpreter() {
        globalFrame = new Frame();
        this.currentEnv = this.globalFrame;

        //add builtin funcitons to global frame
        globalFrame.assign("read", new Value.Builtin("read", Builtins::read));
        globalFrame.assign("plus", new Value.Builtin("plus", Builtins::plus));
    }

    public Frame getEnv() { return currentEnv; }

    public void setEnv(Frame newEnv) { currentEnv = newEnv; }

    public String readInputLine() {
        return stdin.nextLine();
    }

    /** Calls the Tokenizer to extract tokens from the source text file. */
    public static TokenStream getTokens(Path sourceFile) throws IOException {
        return new Tokenizer(
            Interpreter.class.getResourceAsStream("tokenSpec.txt"),
            ParseRules.VOCABULARY
        ).streamFrom(sourceFile);
    }

    /** Calls the ANTLR-generated parser to form the tokens into a parse tree. */
    public static ParseRules.ProgContext parse(TokenStream tokens) {
        ParseRules parser = new ParseRules(tokens);
        Errors.register(parser);
        return parser.prog();
    }

    /** Does scanning, parsing, AST generation, and finally AST execution. */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            Errors.error("need 1 command-line arg: input source file");
        }
        Path sourceFile = Path.of(args[0]);
        TokenStream tokens = getTokens(sourceFile);
        ParseRules.ProgContext ptreeRoot = parse(tokens);
        Stmt astRoot = ASTGen.gen(ptreeRoot);
        astRoot.exec(new Interpreter());
    }

    /** Executes a function definition statement (with parameters). */
    public void execFUNCStat(Stmt.FUNCStat stat) {
        // 1. Get the current environment (Frame).
        Frame capturedEnv = getEnv(); 

        // 2. Create the Closure value.
        Value.Closure closure = new Value.Closure(
            stat.name(),       
            stat.params(),    
            stat.body(),       
            capturedEnv      
        );

        // 3. Bind the Closure to the function name in the current environment.
        getEnv().assign(stat.name(), closure); 
    }

    public void execFUNCVOIDStat(Stmt.FUNCVOIDStat stat) {
        // 1. Get the current environment (Frame) 
        Frame capturedEnv = getEnv(); 

        // 2. Create the Closure value with an empty parameter list.
        Value.Closure closure = new Value.Closure(
            stat.name(),
            new ArrayList<String>(), // Now ArrayList is imported
            stat.body(),
            capturedEnv  // capturedEnv is now defined
        );

        // 3. Bind the Closure to the function name in the current environment.
        getEnv().assign(stat.name(), closure);
    }

    /**
     * Evaluates a function call expression or executes a function call statement.
     * Returns the function's return value (or a default value if used as a statement).
     */
    public Value evalFuncCall(String name, List<Expr> args) {
        // 1. Function Lookup and Validation (remains the same)
        Value funcVal = getEnv().lookup(name);

        if (funcVal instanceof Value.Builtin builtin) {
            // Evaluate arguments immediately
            List<Value> argValues = new ArrayList<>();
            for (Expr argExpr : args) {
                argValues.add(argExpr.eval(this));
            }
            
            // Execute the built-in function logic from Builtins.java
            return builtin.logic().apply(argValues);
        }
        
        if (!(funcVal instanceof Value.Closure closure)) {
            return Errors.error(String.format("Runtime Error: '%s' is not a callable function.", name));
        }

        if (args.size() != closure.params().size()) {
            return Errors.error(String.format(
                "Runtime Error: Function '%s' expected %d arguments but received %d.",
                name, closure.params().size(), args.size()
            ));
        }

        // 2. Evaluate arguments (remains the same)
        List<Value> argValues = new ArrayList<>();
        for (Expr argExpr : args) {
            argValues.add(argExpr.eval(this));
        }

        // 3. Create the Call Frame (parent is the closure's captured environment)
        Frame callFrame = new Frame(closure.env());
        
        // Bind arguments to parameters in the new frame
        for (int i = 0; i < closure.params().size(); i++) {
            String paramName = closure.params().get(i);
            Value argValue = argValues.get(i);
            callFrame.assign(paramName, argValue);
        }
        
        // --- Environment SWAP and Execution ---
        
        // Save the environment of the caller
        Frame savedEnv = getEnv(); 
        Value returnValue = null;
        
        try {
            // Set the current environment to the function's call frame
            setEnv(callFrame); // Assuming you have a setEnv(Frame) method
            
            // Execute the function body
            closure.body().exec(this);
            
            // If execution finishes without a 'sleep' (return), implicitly return Bool(false)
            returnValue = new Value.Bool(false); 
            
        } catch (ReturnException e) {
            // Function returned a value using 'sleep expr'
            returnValue = e.returnValue;
            
        } finally {
            // 4. Restore the caller's environment, even if an exception occurred!
            setEnv(savedEnv);
        }
        
        return returnValue;
    }

    public void execReturnStat(Stmt.ReturnStat stat) {
        // 1. Evaluate the expression to get the return value
        Value result = stat.result().eval(this);

        // 2. Throw the exception to terminate the function execution
        throw new ReturnException(result);
    }
}
