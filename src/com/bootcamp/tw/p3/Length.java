package com.bootcamp.tw.p3;

import java.util.Objects;

public class Length {
    private final Double unitValue;
    private final Unit unit;

    private Length(Double unitValue, Unit unit) {
        this.unitValue = unitValue;
        this.unit = unit;
    }

  
    public static Length createFeet(double value ) {
        return new Length(value, Unit.FEET);
    }

    public static Length createInch(double value ) {
        return new Length(value, Unit.INCH);
    }


    boolean compare(Length a){
        if (a.unit.equals(this.unit)){
            return this.equals(a);
        }

        return this.toInch() == a.toInch();
    }

    private double toInch() {
        return switch(unit){
            case Unit.FEET -> unitValue * 12;
            case Unit.INCH -> unitValue;
        };
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

