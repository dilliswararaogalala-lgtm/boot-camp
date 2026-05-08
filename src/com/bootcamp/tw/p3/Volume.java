package com.bootcamp.tw.p3;

import java.util.Objects;

public class Volume {

    private final double unitValueInLiters;

    public Volume(double unitValueInLiters) {
        this.unitValueInLiters = unitValueInLiters;
    }

    public static Volume create(double unitValue, VolumeUnit volumeUnit) throws InvalidUnitValue {
        if (unitValue < 0 ){
            throw new InvalidUnitValue("Invalid Volume "+ unitValue);
        }

        double unitValueInLiters = volumeUnit.toStandard(unitValue);
        return new Volume(unitValueInLiters);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return Double.compare(unitValueInLiters, volume.unitValueInLiters) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unitValueInLiters);
    }
}
