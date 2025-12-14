package com.amazon.vega.commands.vpm;

import com.amazon.vega.VegaDriver;

public class InstallApp extends Vpm {

    public InstallApp(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected Object transformResult(String result) {
        return result;
    }

    public InstallApp usingInstaller(String appFile) {
        super.command = String.format("install /tmp/%s", appFile);
        return this;
    }
}
