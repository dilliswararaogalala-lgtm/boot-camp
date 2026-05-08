package com.bootcamp.tw.p3;

import java.util.Objects;

public class Length {
    private final double unitValue;
    private final Unit unit;

    public Length(double unitValue, Unit Unit) {
        this.unitValue = unitValue;
        this.unit = Unit;
    }

    public static Length createFeet(double value ) {
        return new Length(value, Unit.FEET);
    }

    public static Length createInch(double value) {
        return new Length(value, Unit.INCH);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(unitValue, length.unitValue) == 0 && unit == length.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitValue, unit);
    }
}
