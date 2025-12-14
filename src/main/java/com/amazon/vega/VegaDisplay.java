package com.amazon.vega;

import com.amazon.vega.commands.VegaCommander;
import com.amazon.vega.commands.display.GetCurrentDisplayMode;
import com.amazon.vega.commands.display.SetColorCorrection;
import com.amazon.vega.commands.display.SetColorInversion;
import com.amazon.vega.commands.display.SetDisplayMode;
import com.amazon.vega.commands.display.domain.enums.ColorCorrection;
import com.amazon.vega.commands.display.domain.enums.ColorInversion;
import com.amazon.vega.commands.display.domain.enums.DisplayMode;

public class VegaDisplay {

    private final VegaCommander command;

    public VegaDisplay(VegaDriver driver) {
        command = new VegaCommander(driver);
    }

    public void setMode(DisplayMode displayMode) {
        command.using(SetDisplayMode.class).to(displayMode).execute();
    }

    public String getCurrentMode() {
        return command.using(GetCurrentDisplayMode.class).execute();
    }

    public void setColorInversion(ColorInversion colorInversion) {
        command.using(SetColorInversion.class).to(colorInversion).execute();
    }

    public void setColorCorrection(ColorCorrection colorCorrection) {
        command.using(SetColorCorrection.class).to(colorCorrection).execute();
    }
}
