package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareLengthTest {
    @Test
    void compareInchAndInch() throws InvalidUnitValue {
        Length twelveInches = Length.create(12.0, LengthUnit.INCH);
        Length TwelveInches2 = Length.create(12.0, LengthUnit.INCH);
        assertEquals(twelveInches, (TwelveInches2));
    }

    @Test
    void compareNotEqualInchAndInch() throws InvalidUnitValue {
        Length twelveInches = Length.create(12.0, LengthUnit.INCH);
        Length ElevenInches = Length.create(11.0, LengthUnit.INCH);
         assertNotEquals(twelveInches, (ElevenInches));
    }

    @Test
    void compareFeetAndFeet() throws InvalidUnitValue {
        Length twelveFeet = Length.create(12.0, LengthUnit.FEET);
        Length twelveFeet2 = Length.create(12.0, LengthUnit.FEET);
        assertEquals(twelveFeet, (twelveFeet2));
    }

    @Test
    void compareNotEqualFeetAndFeet() throws InvalidUnitValue {
        Length feet = Length.create(12.0, LengthUnit.FEET);
        Length feet2 = Length.create(1.0, LengthUnit.FEET);
        assertNotEquals(feet, (feet2));
    }

    @Test
    void compareFeetAndInch() throws InvalidUnitValue {
        Length feet = Length.create(12.0, LengthUnit.INCH);
        Length feet2 = Length.create(1.0, LengthUnit.FEET);
        assertEquals(feet, (feet2));
    }

    @Test
    void compareNotEqualFeetAndInch() throws InvalidUnitValue {
        Length feet = Length.create(12.0, LengthUnit.INCH);
        Length feet2 = Length.create(2.0, LengthUnit.FEET);
        assertNotEquals(feet, (feet2));
    }

    @Test
    void compareFeetAndCm() throws InvalidUnitValue {
        Length cm = Length.create(30.0, LengthUnit.CM);
        Length feet = Length.create(1.0, LengthUnit.FEET);
        assertEquals(feet, (cm));
    }

    @Test
    void compareNotEqualFeetAndCm() throws InvalidUnitValue {
        Length cm = Length.create(30.0, LengthUnit.CM);
        Length feet = Length.create(2.0, LengthUnit.FEET);
        assertNotEquals(feet, (cm));
    }


    @Test
    void compareNotEqualInchAndCm() throws InvalidUnitValue {
        Length cm = Length.create(5.0, LengthUnit.CM);
        Length inch = Length.create(3.0, LengthUnit.INCH);
        assertNotEquals(inch, (cm));
    }

    @Test
    void negativeValueShouldThrowException() {
        assertThrows(InvalidUnitValue.class,()->Length.create(-1.0, LengthUnit.CM));
    }

    @Test
    void compareCmAndMm() throws InvalidUnitValue {
        Length fiveCentimeters = Length.create(1.0, LengthUnit.CM);
        Length tenMilliMeter = Length.create(10.0, LengthUnit.MM);
        assertEquals(tenMilliMeter, (fiveCentimeters));
    }

    @Test
    void compareNotEqualCmAndMm() throws InvalidUnitValue {
        Length fiveCentimeters = Length.create(6.0, LengthUnit.CM);
        Length tenMilliMeter = Length.create(10.0, LengthUnit.MM);
        assertNotEquals(tenMilliMeter, (fiveCentimeters));
    }

    @Test
    void addTwoUnitsOfLength() throws InvalidUnitValue {
        Length sixInches = Length.create(6.0, LengthUnit.INCH);
        Length tenInches = Length.create(10.0, LengthUnit.INCH);
        Length sixteenInches = sixInches.add(tenInches);
        assertEquals(Length.create(16.0, LengthUnit.INCH), sixteenInches);
    }

    @Test
    void representUnitInInchesAsStandard() throws InvalidUnitValue {
        Length sixInches = Length.create(6.0, LengthUnit.INCH);
        Length tenInches = Length.create(10.0, LengthUnit.INCH);
        Length sixteenInches = sixInches.add(tenInches);
        assertEquals("16.0 in", sixteenInches.toString());
    }


    @Test
    void representUnitInInchesAsStandardWhenDifferentUnitsAreAdded() throws InvalidUnitValue {
        Length sixInches = Length.create(6.0, LengthUnit.INCH);
        Length oneFeet = Length.create(1.0, LengthUnit.FEET);
        Length eighteenInches = sixInches.add(oneFeet);
        assertEquals("18.0 in", eighteenInches.toString());
    }
    
}
