package com.lngtmg.meter.api.exception;

public class ExceptionDto {

    private String message;

    private String className;

    public ExceptionDto() {}

    public ExceptionDto(final String message, final String className) {
        this.message = message;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(final String className) {
        this.className = className;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionDto{" +
            "message='" + message + '\'' +
            ", className='" + className + '\'' +
            '}';
    }
}
