package com.bootcamp.tw.p3;

public class Length extends Measurement {

    private Length(Double unitsInStandard) {
        super(unitsInStandard);
    }

    static Length create(Double unitValue, LengthUnit lengthUnit) throws InvalidUnitValue {
        if (unitValue < 0) {
            throw new InvalidUnitValue("Negative length Not allowed");
        }
        double unitInStandard = lengthUnit.toStandard(unitValue);
        return new Length(unitInStandard);
    }

    public Length add(Length tenInches) throws InvalidUnitValue {
        return create(tenInches.unitValue + this.unitValue, LengthUnit.STANDARD);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return LengthUnit.INCH.fromStandard(this.unitValue) + " in";
    }
}

