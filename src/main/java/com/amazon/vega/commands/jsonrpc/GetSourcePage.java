package com.amazon.vega.commands.jsonrpc;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.jsonrpc.domain.enums.Method;
import com.amazon.vega.utils.PrettyPrintXml;

public class GetSourcePage extends JsonRpc<String> {

    public GetSourcePage(VegaDriver driver) {
        super(driver, Method.GET_PAGE_SOURCE);
    }

    @Override
    protected String setArguments() {
        return "";
    }

    @Override
    protected String transformResult(String result) {
        String escapedString = result.replace("\n", "");
        String xmlPageSource = escapedString.substring(27, escapedString.length() - 1);
        return PrettyPrintXml.byDom4j(xmlPageSource);
    }
}
