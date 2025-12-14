package com.amazon.vega.commands.video;

import com.amazon.vega.VegaDriver;

public class StopRecordingScreen extends Video {

    public StopRecordingScreen(VegaDriver driver) {
        super(driver);
        this.method = "jsonrpc: stopRecordingScreen";

    }

    @Override
    protected Object setArguments() {
        return "";
//        return new ArrayList<>();
    }
    
    @Override
    protected Object transformResult(String result) {
        System.out.println("StopRecordingScreen: " + result);
        return result;
    }
}
