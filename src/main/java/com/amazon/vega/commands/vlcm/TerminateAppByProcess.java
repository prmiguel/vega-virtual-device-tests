package com.amazon.vega.commands.vlcm;

import com.amazon.vega.VegaDriver;

public class TerminateAppByProcess extends Vlcm {

    public TerminateAppByProcess(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected Object transformResult(String result) {
        return result;
    }

    public TerminateAppByProcess withId(Integer id) {
        super.command = String.format("terminate-app --pid %s", id);
        return this;
    }
}
