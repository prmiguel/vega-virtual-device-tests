package com.amazon.vega.commands.jsonrpc;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.VegaCommand;
import com.amazon.vega.commands.jsonrpc.domain.enums.Method;

public abstract class JsonRpc<T> implements VegaCommand {

    protected VegaDriver driver;
    private Method method;
    private String result;

    protected JsonRpc(VegaDriver driver, Method method) {
        this.driver = driver;
        this.method = method;
    }

    public T execute() {
        this.result = String.valueOf(driver.executeScript(String.format("jsonrpc: %s", this.method.getName()), setArguments()));
        return transformResult(this.result);
    }

    protected abstract Object setArguments();

    protected abstract T transformResult(String result);
}
