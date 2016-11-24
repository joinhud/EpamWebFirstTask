package com.epam.web.first.exception;

public class CandiesStAXException extends Exception {
    public CandiesStAXException() {
        super();
    }

    public CandiesStAXException(String message) {
        super(message);
    }

    public CandiesStAXException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandiesStAXException(Throwable cause) {
        super(cause);
    }

    protected CandiesStAXException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
