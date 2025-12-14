package com.amazon.vega.commands.video;

import com.amazon.vega.VegaDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartRecordingScreen extends Video {

    public StartRecordingScreen(VegaDriver driver) {
        super(driver);
        this.method = "jsonrpc: startRecordingScreen";

    }

    @Override
    protected Object setArguments() {
        List<Map<String, Object>> args = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("timeLimit", 180);
        params.put("username", "root");
        params.put("password", "");
        args.add(params);
        return args;
    }

    @Override
    protected Object transformResult(String result) {
        System.out.println("StartRecordingScreen: " + result);
        return result;
    }
}
