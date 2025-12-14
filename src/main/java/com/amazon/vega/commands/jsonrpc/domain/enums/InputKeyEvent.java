package com.amazon.vega.commands.jsonrpc.domain.enums;

public enum InputKeyEvent {
    ENTER("28"),
    UP("103"),
    LEFT("106"),
    DOWN("108"),
    RIGHT("107");

    private final String key;

    InputKeyEvent(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
