package com.amazon.vega.commands.jsonrpc.domain.enums;

public enum Method {
    GET_PAGE_SOURCE("getPageSource"),
    INJECT_INPUT_KEY_EVENT("injectInputKeyEvent"),
    FIND_OBJECTS("findObjects"),
    CLICK_CENTER("clickCenter");

    private final String name;

    Method(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
