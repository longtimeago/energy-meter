package com.ppol.meter.api.exception;

/**
 * Created by ppolishchuk on 6/1/14.
 */
public class MeterRemoveException extends MeterException {

    public MeterRemoveException(final String message) {
        super(message);
    }

    public MeterRemoveException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
