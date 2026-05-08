package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareTest {
    @Test
    void compareInchAndInch() throws InvalidUnitValue {
        Length inch = Length.createInch(12);
        Length inch2 = Length.createInch(12);
        assertTrue(inch.compare(inch2));
    }

    @Test
    void compareNotEqualInchAndInch() throws InvalidUnitValue {
        Length inch = Length.createInch(12);
        Length inch2 = Length.createInch(11);
        assertFalse(inch.compare(inch2));
    }

    @Test
    void compareFeetAndFeet() throws InvalidUnitValue {
        Length feet = Length.createFeet(12);
        Length feet2 = Length.createFeet(12);
        assertTrue(feet.compare(feet2));
    }

    @Test
    void compareNotEqualFeetAndFeet() throws InvalidUnitValue {
        Length feet = Length.createFeet(12);
        Length feet2 = Length.createFeet(1);
        assertFalse(feet.compare(feet2));
    }

    @Test
    void compareFeetAndInch() throws InvalidUnitValue {
        Length feet = Length.createInch(12);
        Length feet2 = Length.createFeet(1);
        assertTrue(feet.compare(feet2));
    }

    @Test
    void compareNotEqualFeetAndInch() throws InvalidUnitValue {
        Length feet = Length.createInch(12);
        Length feet2 = Length.createFeet(2);
        assertFalse(feet.compare(feet2));
    }

    @Test
    void compareFeetAndCm() throws InvalidUnitValue {
        Length cm = Length.createCm(30);
        Length feet = Length.createFeet(1);
        assertTrue(feet.compare(cm));
    }

    @Test
    void compareNotEqualFeetAndCm() throws InvalidUnitValue {
        Length cm = Length.createCm(30);
        Length feet = Length.createFeet(2);
        assertFalse(feet.compare(cm));
    }


    @Test
    void compareNotEqualInchAndCm() throws InvalidUnitValue {
        Length cm = Length.createCm(5);
        Length inch = Length.createInch(3);
        assertFalse(inch.compare(cm));
    }


    @Test
    void negativeValueShouldThrowException() {
        assertThrows(InvalidUnitValue.class,()->Length.createCm(-1));

    }
}
