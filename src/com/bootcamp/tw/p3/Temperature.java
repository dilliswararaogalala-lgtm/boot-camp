package com.bootcamp.tw.p3;


public class Temperature extends Measurement {

    public Temperature(double unitValue) {
        super(unitValue);
    }

    public static Temperature create(double unitValue, TemperatureUnit unit) {
        double unitValueInStandard = unit.toStandard(unitValue);

        return new Temperature(unitValueInStandard);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

}
