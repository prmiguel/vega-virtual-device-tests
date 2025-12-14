package com.amazon.vega.commands.jsonrpc;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.jsonrpc.domain.enums.Method;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickCenter extends JsonRpc {

    private String id;
    public ClickCenter(VegaDriver driver) {
        super(driver, Method.CLICK_CENTER);
    }

    @Override
    protected Object setArguments() {
        List<Map<String, Object>> args = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("id", Long.parseLong(id));
        args.add(params);
        return args;
    }

    public ClickCenter on(RemoteWebElement element) {
        this.id = element.getId();
        return this;
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }
}
