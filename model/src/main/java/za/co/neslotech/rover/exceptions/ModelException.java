package za.co.neslotech.rover.exceptions;

public class ModelException extends Exception {

    public ModelException(String message) {
        super(message);
    }

    public ModelException(Throwable cause) {
        super(cause);
    }

    public ModelException(String message, Throwable cause) {
        super(message, cause);
    }

}
