package com.amazon.vega.commands.jsonrpc;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.jsonrpc.domain.enums.InputKeyEvent;
import com.amazon.vega.commands.jsonrpc.domain.enums.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InjectInputKeyEvent extends JsonRpc {

    private InputKeyEvent inputKeyEvent;
    private Integer holdDuration = 100;

    public InjectInputKeyEvent(VegaDriver driver) {
        super(driver, Method.INJECT_INPUT_KEY_EVENT);
    }

    @Override
    protected Object setArguments() {
        List<Map<String, Object>> args = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("inputKeyEvent", inputKeyEvent.getKey());
        params.put("holdDuration", holdDuration);
        args.add(params);
        return args;
    }

    public InjectInputKeyEvent on(InputKeyEvent inputKeyEvent) {
        this.inputKeyEvent = inputKeyEvent;
        return this;
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }
}
