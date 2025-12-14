package com.amazon.vega.commands.display.domain.enums;

public enum ColorCorrection {
    Off("0"),
    DEUTERANOMALY("1"),
    PROTANOMALY("2"),
    TRIRANOMALY("3");

    private final String state;

    ColorCorrection(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
