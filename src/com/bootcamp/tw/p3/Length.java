package com.bootcamp.tw.p3;

import java.util.Objects;

import static com.bootcamp.tw.p3.Unit.*;
import static com.bootcamp.tw.p3.Unit.FEET;

public class Length {
    private final Double unitValue;
    private final Unit unit;

    private Length(Double unitValue, Unit unit) {
        this.unitValue = unitValue;
        this.unit = unit;
    }


    public static Length createFeet(double value) {
        return new Length(value, FEET);
    }

    public static Length createInch(double value) {
        return new Length(value, INCH);
    }

    public static Length createCm(double value) {
        return new Length(value, CM);
    }


    boolean compare(Length a) {
        if (a.unit.equals(this.unit)) {
            return this.equals(a);
        }

        double unitInInch = this.toInch();
        double comparatorUnitsInch = a.toInch();
        return unitInInch == comparatorUnitsInch;
    }

    private double toInch() {
        return this.unit.ratioToInch * this.unitValue;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Objects.equals(unitValue, length.unitValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitValue, unit);
    }
}

