package com.bootcamp.tw.p3;
import java.util.Objects;

public class Length {
    private final Double unitValue;
    private final Unit unit;

    private Length(Double unitValue, Unit unit) {
        this.unitValue = unitValue;
        this.unit = unit;
    }

    private static Length createLength(Double unitValue, Unit unit) throws InvalidUnitValue {
        if(unitValue < 0) {
            throw  new InvalidUnitValue("Negative length Not allowed");
        }
        return new Length(unitValue, unit);
    }

    public static Length createFeet(double value) throws InvalidUnitValue {
        return createLength(value, Unit.FEET);
    }

    public static Length createInch(double value) throws InvalidUnitValue {
        return createLength(value, Unit.INCH);
    }

    public static Length createCm(double value) throws InvalidUnitValue {
        return createLength(value, Unit.CM);
    }

    public static Length createMm(double value) throws InvalidUnitValue {
        return createLength(value, Unit.MM);
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

