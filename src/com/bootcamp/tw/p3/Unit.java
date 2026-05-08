package com.bootcamp.tw.p3;

public enum Unit {
    FEET(12),
    CM(0.4),
    INCH(1),
    MM(0.04);

    public final double ratioToInch;

    Unit(double ratioToInch) {
        this.ratioToInch = ratioToInch;
    }
}
