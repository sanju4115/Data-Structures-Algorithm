package com.optional;

import java.util.Optional;

public class DisplayFeatures {
    private String size; // In inches
    private ScreenResolution resolution;

    public DisplayFeatures(String size, ScreenResolution resolution){
        this.size = size;
        this.resolution = resolution;
    }

    public String getSize() {
        return size;
    }

    public Optional<ScreenResolution> getResolution() {
        return Optional.ofNullable(resolution);
    }
}
