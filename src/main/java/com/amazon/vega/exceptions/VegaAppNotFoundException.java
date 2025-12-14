package com.amazon.vega.exceptions;

public class VegaAppNotFoundException extends RuntimeException {
    public VegaAppNotFoundException(String message) {
        super(message);
    }

    public VegaAppNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
