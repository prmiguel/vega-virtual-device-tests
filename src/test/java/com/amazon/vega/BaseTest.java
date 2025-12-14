package com.amazon.vega;

import io.appium.java_client.remote.options.BaseOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected VegaDriver driver;

    protected URL getUrl() {
        try {
            return new URL("http://192.168.0.39:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUp() {
        var options = new BaseOptions()
                .amend("platformName", "Kepler")
                .amend("appium:automationName", "automation-toolkit/JSON-RPC")
                .amend("kepler:device", "vda://default")
                // .amend("appium:app", "keplervideoapp_x86_64-RN72-v09.vpkg")
                .amend("appium:appPackage", "com.amazondeveloper.keplervideoapp.main")
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);
        driver = new VegaDriver(this.getUrl(), options);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
