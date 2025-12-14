package com.amazon.vega.commands.display;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.VegaCommand;

public abstract class DisplayManagerPm<T> implements VegaCommand {

    protected final VegaDriver driver;
    protected String command;
    protected String result;

    protected DisplayManagerPm(VegaDriver driver) {
        this.driver = driver;
    }

    public T execute() {
        this.result = String.valueOf(driver.executeScript("shell", String.format("displayManagerPm %s", this.command)));
        return (T) transformResult(this.result);
    }

    protected abstract T transformResult(String result);
}
