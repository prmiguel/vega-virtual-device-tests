package com.amazon.vega.commands.jsonrpc;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.VegaElement;
import com.amazon.vega.commands.jsonrpc.domain.enums.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindObjects extends JsonRpc<VegaElement> {
    private Map<String, Object> locators = new HashMap<>();
    public FindObjects(VegaDriver driver) {
        super(driver, Method.FIND_OBJECTS);
    }

    @Override
    protected Object setArguments() {
        List<Map<String, Object>> args = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("args", locators);
        params.put("selectorStrategy", "xpath");
        args.add(params);
        return args;
    }

    public FindObjects with(String xpath) {
        locators.put("xpath", xpath);
        return this;
    }

    @Override
    protected VegaElement transformResult(String result) {
        // TODO: return only the first element
        String id = result.substring(28, result.length() -2);
        var vegaElement = new VegaElement(driver, locators.get("xpath").toString());
        vegaElement.setId(id);
        return vegaElement;
    }
}
