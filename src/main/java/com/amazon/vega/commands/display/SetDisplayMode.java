package com.amazon.vega.commands.display;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.display.domain.enums.DisplayMode;

public class SetDisplayMode extends DisplayManagerPm<String> {

    public SetDisplayMode(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }

    public SetDisplayMode to(DisplayMode displayMode) {
        super.command = String.format("set %s", displayMode.getMode());
        return this;
    }
}
