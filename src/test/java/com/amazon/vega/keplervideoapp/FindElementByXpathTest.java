package com.amazon.vega.keplervideoapp;

import com.amazon.vega.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindElementByXpathTest extends BaseTest {

    @Test
    public void findElement() {
        Assert.assertNotNull(driver.findElement("//child[@test_id=\"328\"]"));
    }
}
