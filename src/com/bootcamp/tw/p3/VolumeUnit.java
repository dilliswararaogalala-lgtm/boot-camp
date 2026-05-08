package com.bootcamp.tw.p3;

public enum VolumeUnit {
    GALLON(3.78),
    LITER(1.0),
    STANDARD(1.0);

    private final Double ratioToStandard;

    VolumeUnit(Double ratioToStandard) {
        this.ratioToStandard = ratioToStandard;
    }

    public double toStandard(double unitValue) {
        return this.ratioToStandard * unitValue;
    }

    public Double fromStandard(double unitValue) {
        return unitValue / this.ratioToStandard;
    }
}
