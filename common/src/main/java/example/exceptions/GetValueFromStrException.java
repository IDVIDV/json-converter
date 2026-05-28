package example.exceptions;

public class GetValueFromStrException extends RuntimeException {
    public GetValueFromStrException() {
    }

    public GetValueFromStrException(String message) {
        super(message);
    }

    public GetValueFromStrException(String message, Throwable cause) {
        super(message, cause);
    }
}
