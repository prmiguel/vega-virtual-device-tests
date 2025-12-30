package com.amazon.vega.keplervideoapp;

import com.amazon.vega.BaseTest;
import com.amazon.vega.commands.jsonrpc.domain.enums.InputKeyEvent;
import org.testng.annotations.Test;

public class PlayFirstContentTest extends BaseTest {

    @Test
    public void playFirstContent() {
        driver.pressKey(InputKeyEvent.DOWN);
        driver.pressKey(InputKeyEvent.ENTER);
        waitFor(6);
        driver.pressKey(InputKeyEvent.ENTER);
        waitFor(20);
        System.out.println(driver.getPageSource());
    }
}
