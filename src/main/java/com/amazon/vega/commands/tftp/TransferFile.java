package com.amazon.vega.commands.tftp;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.exceptions.VegaAppNotFoundException;
import org.openqa.selenium.WebDriverException;

public class TransferFile extends Tftp<String> {

    private String fileName;

    public TransferFile(VegaDriver driver) {
        super(driver);
    }

    @Override
    public String execute() {
        try {
            return super.execute();
        } catch (WebDriverException wde) {
            throw new VegaAppNotFoundException(String.format("Vega App '%s' not found.", fileName), wde);
        }
    }

    @Override
    protected String transformResult(String result) {
        return result;
    }

    public TransferFile named(String fileName) {
        this.fileName = fileName;
        super.command = String.format("-g -r apps/%s 10.0.2.2", fileName);
        return this;
    }
}
