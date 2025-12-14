package com.amazon.vega.commands.common;

import com.amazon.vega.VegaDriver;

public class DownloadFile extends Shell<String> {

    private String url;

    public DownloadFile(VegaDriver driver) {
        super(driver);
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }

    public DownloadFile fromURL(String url) {
        this.url = url;
        super.command = String.format("cd /tmp && curl -O %s", url);
        return this;
    }
}
