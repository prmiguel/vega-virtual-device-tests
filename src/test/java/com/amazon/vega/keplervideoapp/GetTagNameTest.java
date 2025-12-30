package com.amazon.vega.keplervideoapp;

import com.amazon.vega.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTagNameTest extends BaseTest {

    @Test
    public void getTagName() {
        Assert.assertEquals(driver.findElement("//child[@test_id=\"328\"]").getTagName(), "child");
    }
}
