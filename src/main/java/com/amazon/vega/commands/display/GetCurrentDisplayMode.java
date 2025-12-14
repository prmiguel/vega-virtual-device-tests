package com.amazon.vega.commands.display;

import com.amazon.vega.VegaDriver;

public class GetCurrentDisplayMode extends DisplayManagerPm<String> {

    public GetCurrentDisplayMode(VegaDriver driver) {
        super(driver);
        super.command = "get_current";
    }

    @Override
    protected String transformResult(String result) {
        return result.trim();
    }
}
