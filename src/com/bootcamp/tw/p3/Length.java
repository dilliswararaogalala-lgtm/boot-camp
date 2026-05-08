package com.bootcamp.tw.p3;
import java.util.Objects;

public class Length {
    private final Double unitValue;

    private Length(Double unitValueInInch) {
        this.unitValue = unitValueInInch;
    }

    private static Length createLength(Double unitValue, Unit unit) throws InvalidUnitValue {
        if(unitValue < 0) {
            throw  new InvalidUnitValue("Negative length Not allowed");
        }

        double unitValueInInch = unitValue * unit.ratioToInch;
        return new Length(unitValueInInch);
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

    boolean compare(Object a) {
       return this.equals(a);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Objects.equals(unitValue, length.unitValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitValue);
    }
}

