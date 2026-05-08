package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareTest {
    @Test
    void compareInchAndInch() {
        Length inch = Length.createInch(12);
        Length inch2 = Length.createInch(12);
        assertTrue(inch.compare(inch2));
    }

    @Test
    void compareNotEqualInchAndInch() {
        Length inch = Length.createInch(12);
        Length inch2 = Length.createInch(11);
        assertFalse(inch.compare(inch2));
    }

    @Test
    void compareFeetAndFeet() {
        Length feet = Length.createFeet(12);
        Length feet2 = Length.createFeet(12);
        assertTrue(feet.compare(feet2));
    }

    @Test
    void compareNotEqualFeetAndFeet() {
        Length feet = Length.createFeet(12);
        Length feet2 = Length.createFeet(1);
        assertFalse(feet.compare(feet2));
    }

    @Test
    void compareFeetAndInch() {
        Length feet = Length.createInch(12);
        Length feet2 = Length.createFeet(1);
        assertTrue(feet.compare(feet2));
    }

    @Test
    void compareNotEqualFeetAndInch() {
        Length feet = Length.createInch(12);
        Length feet2 = Length.createFeet(2);
        assertFalse(feet.compare(feet2));
    }

    @Test
    void compareFeetAndCm() {
        Length cm = Length.createCm(30);
        Length feet = Length.createFeet(1);
        assertTrue(feet.compare(cm));
    }

    @Test
    void compareNotEqualFeetAndCm() {
        Length cm = Length.createCm(30);
        Length feet = Length.createFeet(2);
        assertFalse(feet.compare(cm));
    }


    @Test
    void compareNotEqualInchAndCm() {
        Length cm = Length.createCm(5);
        Length inch = Length.createInch(3);
        assertFalse(inch.compare(cm));
    }
}
