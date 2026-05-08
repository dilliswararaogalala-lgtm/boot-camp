package com.bootcamp.tw.p3;

public enum LengthUnit {
    FEET(12),
    CM(0.4),
    INCH(1),
    MM(0.04);

    public final double ratioToInch;

    LengthUnit(double ratioToInch) {
        this.ratioToInch = ratioToInch;
    }
}
