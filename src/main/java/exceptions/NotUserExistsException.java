package exceptions;

public class NotUserExistsException extends RuntimeException {
    public NotUserExistsException(String message) {
        super(message);
    }
}
