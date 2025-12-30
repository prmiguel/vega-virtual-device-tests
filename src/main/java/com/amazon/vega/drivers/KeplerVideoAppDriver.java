package com.amazon.vega.drivers;

import com.amazon.vega.VegaDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class KeplerVideoAppDriver {

    private static URL getUrl() {
        try {
            return new URL("http://192.168.0.39:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static VegaDriver startInstance() {
        var options = new BaseOptions()
                .amend("platformName", "Kepler")
                .amend("appium:automationName", "automation-toolkit/JSON-RPC")
                .amend("kepler:device", "vda://default")
                // .amend("appium:app", "keplervideoapp_x86_64-RN72-v09.vpkg")
                .amend("appium:appPackage", "com.amazondeveloper.keplervideoapp.main")
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);
        return new VegaDriver(getUrl(), options);
    }

    public static void closeInstance(VegaDriver driver) {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
