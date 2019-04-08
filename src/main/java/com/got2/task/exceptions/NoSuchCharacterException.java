package com.got2.task.exceptions;

public class NoSuchCharacterException extends Exception {
    public NoSuchCharacterException() {
        super();
    }

    public NoSuchCharacterException(String message) {
        super(message);
    }

    public NoSuchCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCharacterException(Throwable cause) {
        super(cause);
    }

    protected NoSuchCharacterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
