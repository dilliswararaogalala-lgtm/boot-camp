package com.bootcamp.tw.p3;
import java.util.Objects;

public class Length {
    private final Double unitValue;

    private Length(Double unitValueInInch) {
        this.unitValue = unitValueInInch;
    }

    static Length create(Double unitValue, LengthUnit lengthUnit) throws InvalidUnitValue {
        if(unitValue < 0) {
            throw  new InvalidUnitValue("Negative length Not allowed");
        }

        double unitValueInInch = unitValue * lengthUnit.ratioToInch;
        return new Length(unitValueInInch);
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

