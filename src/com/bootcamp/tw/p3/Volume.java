package com.bootcamp.tw.p3;

public class Volume extends Measurement {

    public Volume(double unitValue) {
        super(unitValue);
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
        return super.equals(o);
    }

    @Override
    public String toString() {
        return VolumeUnit.LITER.fromStandard(this.unitValue) + " l";
    }
}
