package si413;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/** This represents a single frame, but it is INCOMPLETE.
 * It doesn't have any parent frame or the logic to look up / reassign
 * bindings in the parent frames, which is needed for proper lexical scoping.
 * YOU WILL HAVE TO MODIFY THIS to get things to work!
 */
public class Frame {
    private Map<String, Value> bindings = new HashMap<>();
    private Frame parent;

    public Frame(Frame parent){
        this.parent = parent;
    }

    public Frame(){
        this(null);
    }

    public Value lookup(String name) {
        if (bindings.containsKey(name)) {
            return bindings.get(name);
        } else if (parent != null) { // ⬅️ NEW: Check parent frame if binding not local
            return parent.lookup(name);
        } else {
            // If not found locally and no parent, it's an error
            return Errors.error(String.format("No binding found for %s in environment", name));
        }
    }

    public void assign(String name, Value val) {
        //  NEW: Search for the variable in the current frame or parents
        if (bindings.containsKey(name)) {
            // Found locally, reassign it here
            bindings.put(name, val);
        } else if (parent != null && parent.canReassign(name)) {
            // Not found locally, but found in a parent frame, reassign there
            parent.assign(name, val);
        } else {
            // Not found anywhere up the chain, so create a new binding locally
            bindings.put(name, val);
        }
    }

    /** Helper method to check if a variable is bound in this frame or any parent frame. */
    public boolean canReassign(String name) {
        if (bindings.containsKey(name)) {
            return true;
        } else if (parent != null) {
            return parent.canReassign(name);
        } else {
            return false;
        }
    }
}
