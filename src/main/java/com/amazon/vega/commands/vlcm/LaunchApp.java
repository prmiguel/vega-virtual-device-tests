package com.amazon.vega.commands.vlcm;

import com.amazon.vega.VegaDriver;

public class LaunchApp extends Vlcm {

    public LaunchApp(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected Object transformResult(String result) {
        return result;
    }

    public LaunchApp withURI(String uri) {
        super.command = String.format("launch-app %s", uri);
        return this;
    }
}
