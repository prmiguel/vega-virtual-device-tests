package com.amazon.vega;

import com.amazon.vega.drivers.KeplerVideoAppDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected VegaDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = KeplerVideoAppDriver.startInstance();
        waitFor(10);
    }

    @AfterMethod
    public void tearDown() {
        KeplerVideoAppDriver.closeInstance(driver);
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
