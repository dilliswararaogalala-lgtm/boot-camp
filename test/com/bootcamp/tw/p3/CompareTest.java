package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {
    @Test
    void createFeetClass() {
        Length feet1 = Length.createFeet(1);
        Length feet2 = Length.createFeet(1);
        assertEquals(feet1, feet2);
    }

    @Test
    void createInch() {
        Length inch1 = Length.createInch(1);
        Length inch2 = Length.createInch(1);
        assertEquals(inch1, inch2);
    }




}
