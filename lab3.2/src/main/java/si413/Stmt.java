package si413;

import java.util.List;

/** AST nodes for statements.
 * Statements can be executed but do not return a value.
 */
public interface Stmt {
    /** Executes this AST node in an interpreter. */
    void exec(Interpreter interp);

    /** Compiles this AST node.
     * The Compiler instance comp is used to store shared state
     * of the running compiler, such as the destination output stream.
     */
    void compile(Compiler comp);

    // ******** AST Node types for statements ******** //

    record Block(List<Stmt> children) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            for (Stmt child : children) {
                child.exec(interp);
            }
        }

        @Override
        public void compile(Compiler comp) {
            for (Stmt child: children) {
                child.compile(comp);
            }
        }
    }

    record ExprStmt(Expr<?> child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            child.eval(interp);
        }

        @Override
        public void compile(Compiler comp) {
            child.compile(comp);
        }
    }

    record AssignString(String name, Expr<String> child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            String val = child.eval(interp);
            interp.getStringVars().put(name, val);
        }

        @Override
        public void compile(Compiler comp) {
            String rvalReg = child.compile(comp);
            String addrReg;
            
            // FIX: Use the getter method to check if the map contains the key.
            if (!comp.getStringVarAddresses().containsKey(name)) {
                addrReg = comp.allocateStringVar(name);
            } else {
                addrReg = comp.getStringVarAddress(name);
            }
            
            comp.dest().format("  store i8* %s, i8** %s\n", rvalReg, addrReg);
        }
    }

    record AssignBool(String name, Expr<Boolean> child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            boolean val = child.eval(interp);
            interp.getBoolVars().put(name, val);
        }

        @Override
        public void compile(Compiler comp) {
            String rvalReg = child.compile(comp);
            String addrReg;

            // FIX: Use the getter method to check if the map contains the key.
            if (!comp.getBoolVarAddresses().containsKey(name)) {
                addrReg = comp.allocateBoolVar(name);
            } else {
                addrReg = comp.getBoolVarAddress(name);
            }
            
            comp.dest().format("  store i1 %s, i1* %s\n", rvalReg, addrReg);
        }
    }

    record PrintString(Expr<String> child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            System.out.println(child.eval(interp));
        }

        @Override
        public void compile(Compiler comp) {
            String chreg = child.compile(comp);
            comp.dest().format("  call i32 @puts(i8* %s)\n", chreg);
        }
    }

    record PrintBool(Expr<Boolean> child) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            if (child.eval(interp)) System.out.println("True");
            else System.out.println("False");
        }

        @Override
        public void compile(Compiler comp) {
            String chreg = child.compile(comp);
            comp.dest().format("  call void @print_bool(i1 %s)\n", chreg);
        }
    }

    record IfElse(Expr<Boolean> condition, Stmt ifBody, Stmt elseBody) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            if (condition.eval(interp)) {
                ifBody.exec(interp);
            }
            else {
                elseBody.exec(interp);
            }
        }

        @Override
        public void compile(Compiler comp) {
            // Get a unique label number for this if-else block
            int labelNum = comp.nextLabelNum();
            String ifTrueLabel = String.format("if_true_L%d", labelNum);
            String ifFalseLabel = String.format("if_false_L%d", labelNum);
            String ifEndLabel = String.format("if_end_L%d", labelNum);

            // 1. Compile the condition (results in an i1 register)
            String condReg = condition.compile(comp);

            // 2. Generate Conditional Branch (br i1)
            // Branch to 'if_true' if cond is true, otherwise branch to 'if_false'
            comp.dest().format("  br i1 %s, label %%%s, label %%%s\n", condReg, ifTrueLabel, ifFalseLabel);

            // --- IF TRUE BLOCK ---
            // 3. Emit the 'if-true' label
            comp.dest().format("%s:\n", ifTrueLabel);
            // Compile the 'if' body
            ifBody.compile(comp);
            
            // Unconditional branch to the 'if_end' label to skip the 'else' block
            comp.dest().format("  br label %%%s\n", ifEndLabel);

            // --- IF FALSE (ELSE) BLOCK ---
            // 4. Emit the 'if-false' label
            comp.dest().format("%s:\n", ifFalseLabel);
            // Compile the 'else' body
            elseBody.compile(comp);

            // Unconditional branch to the 'if_end' label
            comp.dest().format("  br label %%%s\n", ifEndLabel);

            // --- MERGE POINT ---
            // 5. Emit the 'if-end' label (the merge point after the conditional logic)
            comp.dest().format("%s:\n", ifEndLabel);
        }
    }

    record While(Expr<Boolean> condition, Stmt body) implements Stmt {
        @Override
        public void exec(Interpreter interp) {
            while (condition.eval(interp)) {
                body.exec(interp);
            }
        }

        public void compile(Compiler comp) {
            // 1. Get unique labels
            int labelNum = comp.nextLabelNum();
            String loopHeaderLabel = String.format("loop_header_L%d", labelNum);
            String loopBodyLabel = String.format("loop_body_L%d", labelNum);
            String loopEndLabel = String.format("loop_end_L%d", labelNum);

            // 2. Initial Unconditional Jump to the header
            // All flow must enter the loop header to check the condition first.
            comp.dest().format("  br label %%%s\n", loopHeaderLabel);

            // --- LOOP HEADER BLOCK ---
            // 3. Emit the header label
            comp.dest().format("%s:\n", loopHeaderLabel);

            // 4. Compile the condition (results in an i1 register)
            String condReg = condition.compile(comp);

            // 5. Conditional Branch (br i1)
            // Branch to 'loop_body' if true, otherwise branch to 'loop_end'
            comp.dest().format("  br i1 %s, label %%%s, label %%%s\n", condReg, loopBodyLabel, loopEndLabel);

            // --- LOOP BODY BLOCK ---
            // 6. Emit the body label
            comp.dest().format("%s:\n", loopBodyLabel);

            // 7. Compile the loop body
            body.compile(comp);

            // 8. Unconditional Back-Edge Jump
            // Jump back to the header to re-check the condition
            comp.dest().format("  br label %%%s\n", loopHeaderLabel);

            // --- LOOP END BLOCK ---
            // 9. Emit the exit label (the merge point)
            comp.dest().format("%s:\n", loopEndLabel);
        }
    }
}
