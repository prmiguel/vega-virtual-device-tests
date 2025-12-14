package com.amazon.vega.commands.vlcm;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.VegaCommand;

public abstract class Vlcm<T> implements VegaCommand {

    protected final VegaDriver driver;
    protected String command;
    protected String result;

    protected Vlcm(VegaDriver driver) {
        this.driver = driver;
    }

    public T execute() {
        this.result = String.valueOf(driver.executeScript("shell", String.format("vlcm %s", this.command)));
        return transformResult(this.result);
    }

    protected abstract T transformResult(String result);
}
