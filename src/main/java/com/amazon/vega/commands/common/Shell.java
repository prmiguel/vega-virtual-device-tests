package com.amazon.vega.commands.common;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.VegaCommand;

public abstract class Shell<T> implements VegaCommand {

    protected final VegaDriver driver;
    protected String command;
    protected String result;

    protected Shell(VegaDriver driver) {
        this.driver = driver;
    }

    public T execute() {
        this.result = String.valueOf(driver.executeScript("shell", this.command));
        return transformResult(this.result);
    }

    protected abstract T transformResult(String result);
}
