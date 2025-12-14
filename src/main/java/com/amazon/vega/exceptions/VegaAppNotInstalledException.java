package com.amazon.vega.exceptions;

public class VegaAppNotInstalledException extends RuntimeException {
    public VegaAppNotInstalledException(String message) {
        super(message);
    }

    public VegaAppNotInstalledException(String message, Throwable cause) {
        super(message, cause);
    }
}
