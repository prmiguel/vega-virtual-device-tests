package com.amazon.vega.commands;

import com.amazon.vega.VegaDriver;

import java.lang.reflect.InvocationTargetException;

public class VegaCommander {
    private final VegaDriver driver;
    public VegaCommander(VegaDriver driver) {
        this.driver = driver;
    }

    public <T extends VegaCommand> T using(Class<T> clsT)
    {
        T newT;
        try {
            newT = (T) clsT.getDeclaredConstructor(VegaDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                 | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
        return newT;
    }
}
