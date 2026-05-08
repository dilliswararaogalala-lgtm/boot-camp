package com.bootcamp.tw.p3;
import java.util.Objects;

public class Length {
    private final Double unitValue;

    private Length(Double unitsInStandard) {
        this.unitValue = unitsInStandard;
    }

    static Length create(Double unitValue, LengthUnit lengthUnit) throws InvalidUnitValue {
        if(unitValue < 0) {
            throw  new InvalidUnitValue("Negative length Not allowed");
        }

        double unitInStandard = lengthUnit.toStandard(unitValue);

        return new Length(unitInStandard);
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

    public Length add(Length tenInches) throws InvalidUnitValue {
        return create(tenInches.unitValue + this.unitValue, LengthUnit.STANDARD);
    }


    @Override
    public String toString() {
        return LengthUnit.INCH.fromStandard(this.unitValue)+" in" ;
    }
}

