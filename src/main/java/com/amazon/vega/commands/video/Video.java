package com.amazon.vega.commands.video;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.VegaCommand;

public abstract class Video<T> implements VegaCommand {
    protected final VegaDriver driver;
    protected String method;
    protected String result;

    protected Video(VegaDriver driver) {
        this.driver = driver;
    }

    public T execute() {
        this.result = String.valueOf(driver.executeScript(this.method, setArguments()));
        return transformResult(this.result);
    }

    protected abstract Object setArguments();

    protected abstract T transformResult(String result);
}
