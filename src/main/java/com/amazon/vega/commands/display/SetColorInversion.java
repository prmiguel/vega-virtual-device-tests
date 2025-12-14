package com.amazon.vega.commands.display;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.display.domain.enums.ColorInversion;

public class SetColorInversion extends DisplayManagerPm<String> {

    public SetColorInversion(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }

    public SetColorInversion to(ColorInversion colorInversion) {
        super.command = String.format("setci %s", colorInversion.getState());
        return this;
    }
}
