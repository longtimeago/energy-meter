package com.ppol.meter.api.exception;

public class MeterException extends RuntimeException {

    public MeterException() {}

    public MeterException(final String message) {
        super(message);
    }
    public MeterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
