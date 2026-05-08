package com.bootcamp.tw.p3;

import java.util.Objects;

public class Temperature {
    private final double unitValue;

    public Temperature(double unitValue) {
        this.unitValue = unitValue;
    }

    public static Temperature create(double unitValue, TemperatureUnit unit) {
        double unitValueInStandard = unit.toStandard(unitValue);

        return new Temperature(unitValueInStandard);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;

        return Double.compare(unitValue, that.unitValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unitValue);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "unitValue=" + unitValue +
                '}';
    }
}
