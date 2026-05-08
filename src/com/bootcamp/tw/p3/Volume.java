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
    
    public Volume add(Volume otherVolume) throws InvalidUnitValue {
       return create(otherVolume.unitValueInLiters + this.unitValueInLiters, VolumeUnit.STANDARD);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;

        return Math.abs(unitValueInLiters - volume.unitValueInLiters) < 1e-2;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unitValueInLiters);
    }
}
