package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareVolumeTest {
    @Test
    void compareGallonAndGallon() throws InvalidUnitValue {
        Volume OneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume OneGallon2 = Volume.create(1, VolumeUnit.GALLON);
        assertEquals(OneGallon, OneGallon2);
    }

    @Test
    void compareNotEqualGallonAndGallon() throws InvalidUnitValue {
        Volume OneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume TwoGallon = Volume.create(2, VolumeUnit.GALLON);
        assertNotEquals(OneGallon, TwoGallon);
    }


    @Test
    void compareLiterAndLiter() throws InvalidUnitValue {
        Volume oneLiter = Volume.create(1, VolumeUnit.LITER);
        Volume oneLiter2 = Volume.create(1, VolumeUnit.LITER);
        assertEquals(oneLiter, oneLiter2);
    }

    @Test
    void compareNotEqualLiterAndLiter() throws InvalidUnitValue {
        Volume oneLiter = Volume.create(1, VolumeUnit.LITER);
        Volume twoLiter = Volume.create(2, VolumeUnit.LITER);
        assertNotEquals(oneLiter, twoLiter);
    }

    @Test
    void compareGallonAndLiter() throws InvalidUnitValue {
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume oneGallonInLiter = Volume.create(3.78, VolumeUnit.LITER);
        assertEquals(oneGallon, oneGallonInLiter);
    }


    @Test
    void compareNotEqualGallonAndLiter() throws InvalidUnitValue {
        Volume oneLiter = Volume.create(1, VolumeUnit.LITER);
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        assertNotEquals(oneLiter, oneGallon);
    }

    @Test
    void negativeValueShouldThrowException() {
        assertThrows(InvalidUnitValue.class,()-> Volume.create(-1, VolumeUnit.GALLON));
        assertThrows(InvalidUnitValue.class,()-> Volume.create(-1, VolumeUnit.LITER));
    }


    @Test
    void addingGallonAndLiter() throws InvalidUnitValue {
        Volume oneLiter = Volume.create(1, VolumeUnit.LITER);
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume fourPointSevenEightLiter = oneGallon.add(oneLiter);
        assertEquals(Volume.create(4.78, VolumeUnit.LITER), fourPointSevenEightLiter);
    }
}
