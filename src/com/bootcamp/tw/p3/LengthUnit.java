package com.bootcamp.tw.p3;

public enum LengthUnit {
    FEET(12),
    CM(0.4),
    INCH(1),
    MM(0.04),
    STANDARD(1);

    private final double ratioToStandard;

    LengthUnit(double ratioToStandard) {
        this.ratioToStandard = ratioToStandard;
    }
    public double toStandard(double value){
        return value * this.ratioToStandard;
    }

    public Double fromStandard(Double unitValue) {
        return unitValue / this.ratioToStandard;
    }
}
