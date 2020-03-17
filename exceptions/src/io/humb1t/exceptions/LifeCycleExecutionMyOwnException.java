package io.humb1t.exceptions;

public class LifeCycleExecutionMyOwnException extends Exception {
    public LifeCycleExecutionMyOwnException() {
    }

    public LifeCycleExecutionMyOwnException(String message) {
        super(message);
    }

    public LifeCycleExecutionMyOwnException(String message, Throwable cause) {
        super(message, cause);
    }
}
