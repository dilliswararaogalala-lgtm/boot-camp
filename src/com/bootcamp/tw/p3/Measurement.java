package com.bootcamp.tw.p3;

import java.util.Objects;


public abstract class Measurement {
    protected final Double unitValue;
    private final Double EPSILON = 1e-4;

    public Measurement(Double unitsInStandard) {
        this.unitValue = unitsInStandard;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Measurement measurement = (Measurement) o;
        return Math.abs(unitValue - measurement.unitValue) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitValue);
    }

}
