package com.amazon.vega;

import com.amazon.vega.commands.jsonrpc.domain.enums.InputKeyEvent;
import org.testng.annotations.Test;

public class VegaAppTest extends BaseTest {

    @Test
    public void sampleTest() throws InterruptedException {
        Thread.sleep(10000);
        driver.pressKey(InputKeyEvent.DOWN);
        driver.pressKey(InputKeyEvent.ENTER);
        Thread.sleep(6000);
        driver.pressKey(InputKeyEvent.ENTER);
        Thread.sleep(20000);
        System.out.println(driver.getPageSource());
    }
}
