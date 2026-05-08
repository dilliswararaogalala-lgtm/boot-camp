package com.bootcamp.tw.p3;

public enum Unit {
    FEET(12),
    CM(0.4), INCH(1);

    public final double ratioToInch;

    Unit(double ratioToInch) {
        this.ratioToInch = ratioToInch;
    }



}
