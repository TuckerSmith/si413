package si413;

import java.util.List;

/** AST nodes for statements.
 * Statements can be executed but do not return a value.
 */
public interface Stmt {
    /** Executes this AST node in an interpreter. */
    void exec(Interpreter interp);

    // ******** AST Node types for statements ******** //

    record Block(List<Stmt> children) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            for (Stmt child : children) {
                child.exec(interp);
            }
        }
    }

    record ExprStmt(Expr child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            child.eval(interp);
        }
    }


    record Assign(String name, Expr child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            Value val = child.eval(interp);
            interp.getEnv().assign(name, val);
        }
    }

    record Print(Expr child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            System.out.println(child.eval(interp));
        }
    }

    record IfElse(Expr condition, Stmt ifBody, Stmt elseBody) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            if (condition.eval(interp).bool()) {
                ifBody.exec(interp);
            }
            else {
                elseBody.exec(interp);
            }
        }
    }

    record While(Expr condition, Stmt body) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            while (condition.eval(interp).bool()) {
                body.exec(interp);
            }
        }
    }

    record FUNCStat(String name, List<String> params, Inner body) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            interp.execFUNCStat(this); 
        }
    }

    record FUNCVOIDStat(String name, Inner body) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            interp.execFUNCVOIDStat(this);
        }
    }

    record FunctionCallStmt(String name, List<Expr> args) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            interp.evalFuncCall(name, args); 
        }
    }

    record ReturnStat(Expr result) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            // Implementation Note: This must evaluate the result and use an exception 
            // or a special mechanism to unwind the call stack back to the caller frame.
            // It signals the end of the current function's execution.
            interp.execReturnStat(this);
        }

        
    }

    record Inner(List<Stmt> children) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            for (Stmt child : children) {
                child.exec(interp);
            }
        }
    }
}


