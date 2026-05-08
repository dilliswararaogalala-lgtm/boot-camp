package com.bootcamp.tw.p3;

public enum VolumeUnit {
    GALLON(3.78),
    LITER(1.0),
    STANDARD(1.0);

    private final Double ratioToLiter;

    VolumeUnit(Double ratioToLiter) {
        this.ratioToLiter = ratioToLiter;
    }

    public double toStandard(double unitValue) {
        return this.ratioToLiter * unitValue;
    }
}
