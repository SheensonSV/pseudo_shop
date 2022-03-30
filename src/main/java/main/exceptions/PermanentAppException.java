package main.exceptions;

public class PermanentAppException extends RuntimeException {
    public PermanentAppException(String errorMessage) {
        super(errorMessage);
    }
}
