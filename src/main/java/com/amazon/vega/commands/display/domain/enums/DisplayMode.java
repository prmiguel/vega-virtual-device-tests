package com.amazon.vega.commands.display.domain.enums;

public enum DisplayMode {
    ACTIVE("active"),
    SLEEP("sleep");

    private final String mode;

    DisplayMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }
}
