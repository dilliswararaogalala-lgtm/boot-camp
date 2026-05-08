package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompareTest {
    @Test
    void createFeetClass() {
        Length feet1 = Length.createFeet(1);
        Length feet2 = Length.createFeet(1);
        assertEquals(feet1, feet2);
    }

    @Test
    void createInchClass() {
        Length inch = Length.createInch(1);
        Length inch2 = Length.createInch(1);
        assertEquals(inch, inch2);
    }

    @Test
    void compareInchAndInch() {
        Length inch = Length.createInch(12);
        Length inch2 = Length.createInch(12);
        assertTrue(inch.compare(inch2));
    }

    @Test
    void compareFeetAndFeet() {
        Length feet = Length.createFeet(12);
        Length feet2 = Length.createFeet(12);
        assertTrue(feet.compare(feet2));
    }

    @Test
    void compareFeetAndInch() {
        Length feet = Length.createInch(12);
        Length feet2 = Length.createFeet(1);
        assertTrue(feet.compare(feet2));
    }
}
