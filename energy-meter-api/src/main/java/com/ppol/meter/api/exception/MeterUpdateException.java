package com.ppol.meter.api.exception;

public class MeterUpdateException extends MeterException {

    public MeterUpdateException(final String message) {
        super(message);
    }

    public MeterUpdateException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
