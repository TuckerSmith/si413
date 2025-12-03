package si413;

public class ReturnException extends RuntimeException {
    public final Value returnValue;

    public ReturnException(Value returnValue) {
        super(null, null, false, false); 
        this.returnValue = returnValue;
    }
}