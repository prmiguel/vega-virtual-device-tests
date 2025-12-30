package com.amazon.vega.keplervideoapp;

import com.amazon.vega.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintSourcePageTest extends BaseTest {

    @Test
    public void playFirstContent() {
        Assert.assertFalse(driver.getPageSource().isEmpty());
    }
}
