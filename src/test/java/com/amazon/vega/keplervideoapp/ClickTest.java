package com.amazon.vega.keplervideoapp;

import com.amazon.vega.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickTest extends BaseTest {

    @Test
    public void click() {
        driver.findElement("//child[@test_id=\"328\"]").click();
        waitFor(5);
        Assert.assertTrue(true);
    }
}
