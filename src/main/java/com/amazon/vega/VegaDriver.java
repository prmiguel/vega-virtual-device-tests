package com.amazon.vega;

import com.amazon.vega.commands.VegaCommander;
import com.amazon.vega.commands.common.DownloadFile;
import com.amazon.vega.commands.jsonrpc.FindObjects;
import com.amazon.vega.commands.jsonrpc.GetSourcePage;
import com.amazon.vega.commands.jsonrpc.InjectInputKeyEvent;
import com.amazon.vega.commands.jsonrpc.domain.enums.InputKeyEvent;
import com.amazon.vega.commands.tftp.TransferFile;
import com.amazon.vega.commands.vlcm.LaunchApp;
import com.amazon.vega.commands.vlcm.ListAppByApp;
import com.amazon.vega.commands.vlcm.TerminateAppByProcess;
import com.amazon.vega.commands.vlcm.domain.AppDetails;
import com.amazon.vega.commands.vpm.InstallApp;
import com.amazon.vega.exceptions.VegaAppNotInstalledException;
import com.amazon.vega.utils.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class VegaDriver extends RemoteWebDriver {
    private AppDetails appDetails;
    private final VegaCommander command;

    public VegaDriver(URL remoteAddress, Capabilities capabilities) {
        super(remoteAddress, capabilities);
        command = new VegaCommander(this);
        this.installAppIfCapabilityIsProvided();
        this.launchAppIfCapabilityIsProvided();
    }

    @Override
    public void get(String url) {
        try {
            command.using(LaunchApp.class).withURI(url).execute();
            URI uri = new URI(url);
            await().atMost(Duration.ofSeconds(10)).until(() -> {
                this.appDetails = command.using(ListAppByApp.class).withApp(uri.getAuthority()).execute();
                return this.appDetails.pid() != 0;
            });
        } catch (WebDriverException | URISyntaxException wde) {
            throw new VegaAppNotInstalledException(String.format("Vega App '%s' not installed.", url), wde);
        }
    }

    @Override
    public String getPageSource() {
        return command.using(GetSourcePage.class).execute();
    }

    @Override
    public void close() {
        command.using(TerminateAppByProcess.class).withId(this.appDetails.pid()).execute();
    }

    private void copyAppBinaryIntoSimulator(String appFile) {
        command.using(TransferFile.class).named(appFile).execute();
    }

    private void downloadAppBinaryIntoSimulator(String appFile) {
        command.using(DownloadFile.class)
                .fromURL(this.getCapabilities().getCapability("app").toString())
                .execute();
    }

    private void getAppBinaryIntoSimulator(String app) {
        if (app.startsWith("http")) {
            downloadAppBinaryIntoSimulator(app);
        } else {
            this.copyAppBinaryIntoSimulator(app);
        }
    }

    private void installApp(String appFile) {
        command.using(InstallApp.class).usingInstaller(appFile).execute();
    }

    private void installAppIfCapabilityIsProvided() {
        if (this.getCapabilities().getCapabilityNames().contains("app")) {
            String app = this.getCapabilities().getCapability("app").toString();
            getAppBinaryIntoSimulator(app);
            this.installApp(FileUtils.getFileNameFromUri(app));
        }
    }

    private void launchAppIfCapabilityIsProvided() {
        if (this.getCapabilities().getCapabilityNames().contains("appPackage")) {
            this.get(String.format("orpheus://%s", this.getCapabilities().getCapability("appPackage").toString()));
        }
    }

    public void pressKey(InputKeyEvent inputKeyEvent) {
        command.using(InjectInputKeyEvent.class).on(inputKeyEvent).execute();
    }

    public VegaElement findElement(String locator) {
        return  command.using(FindObjects.class).with(locator).execute();
    }

    public VegaDisplay display() {
        return new VegaDisplay(this);
    }
}
