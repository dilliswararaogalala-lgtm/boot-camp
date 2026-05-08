package com.bootcamp.tw.p3;

import java.util.Objects;

public class Volume {

    private final double unitValue;

    public Volume(double unitValue) {
        this.unitValue = unitValue;
    }

    public static Volume create(double unitValue, VolumeUnit volumeUnit) throws InvalidUnitValue {
        if (unitValue < 0 ){
            throw new InvalidUnitValue("Invalid Volume "+ unitValue);
        }

        double unitValueInStandard = volumeUnit.toStandard(unitValue);
        return new Volume(unitValueInStandard);
    }
    
    public Volume add(Volume otherVolume) throws InvalidUnitValue {
       return create(otherVolume.unitValue + this.unitValue, VolumeUnit.STANDARD);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;

        return Math.abs(unitValue - volume.unitValue) < 1e-2;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unitValue);
    }

    @Override
    public String toString() {
        return VolumeUnit.LITER.fromStandard(this.unitValue) + " l";
    }
}
