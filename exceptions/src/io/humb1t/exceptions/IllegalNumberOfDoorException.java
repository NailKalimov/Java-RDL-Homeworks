package io.humb1t.exceptions;

public class IllegalNumberOfDoorException extends Exception {
    public IllegalNumberOfDoorException() {
    }

    public IllegalNumberOfDoorException(String message) {
        super(message);
    }

    public IllegalNumberOfDoorException(String message, Throwable cause) {
        super(message, cause);
    }
}
