package com.amazon.vega;

import com.amazon.vega.commands.VegaCommander;
import com.amazon.vega.commands.jsonrpc.ClickCenter;
import com.amazon.vega.commands.jsonrpc.GetSourcePage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.remote.RemoteWebElement;


public class VegaElement extends RemoteWebElement {

    private final VegaCommander command;
    private final String locator;
    private String tagName;
    public VegaElement(VegaDriver driver, String locator) {
        command = new VegaCommander(driver);
        this.locator = locator;
        this.setOpt();
    }

    @Override
    public void click() {
        command.using(ClickCenter.class).on(this).execute();
    }

    @Override
    public String getTagName() {
        return this.tagName;
    }

    private void setOpt() {
        String sourcePage = command.using(GetSourcePage.class).execute();
        Document doc = Jsoup.parse(sourcePage);
        Elements elements = doc.selectXpath(locator);
        this.tagName = elements.stream().findFirst().get().tagName();
    }
}
