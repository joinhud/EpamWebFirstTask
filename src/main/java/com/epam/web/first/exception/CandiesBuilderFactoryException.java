package com.epam.web.first.exception;

public class CandiesBuilderFactoryException extends Exception {
    public CandiesBuilderFactoryException() {
        super();
    }

    public CandiesBuilderFactoryException(String message) {
        super(message);
    }

    public CandiesBuilderFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandiesBuilderFactoryException(Throwable cause) {
        super(cause);
    }

    protected CandiesBuilderFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
