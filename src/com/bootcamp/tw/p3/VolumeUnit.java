package com.bootcamp.tw.p3;

public enum VolumeUnit {
    GALLON(3.78),
    LITER(1.0);

    public final Double ratioToLiter;

    VolumeUnit(Double ratioToLiter) {
        this.ratioToLiter = ratioToLiter;
    }
}
