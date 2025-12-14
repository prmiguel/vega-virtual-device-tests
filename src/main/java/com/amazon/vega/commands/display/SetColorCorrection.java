package com.amazon.vega.commands.display;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.display.domain.enums.ColorCorrection;

public class SetColorCorrection extends DisplayManagerPm<String> {

    public SetColorCorrection(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }

    public SetColorCorrection to(ColorCorrection colorCorrection) {
        super.command = String.format("set_cc %s", colorCorrection.getState());
        return this;
    }
}
