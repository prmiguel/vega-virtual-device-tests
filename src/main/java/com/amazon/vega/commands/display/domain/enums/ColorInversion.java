package com.amazon.vega.commands.display.domain.enums;

public enum ColorInversion {
    DISABLE("0"),
    ENABLE("1");

    private final String state;

    ColorInversion(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
