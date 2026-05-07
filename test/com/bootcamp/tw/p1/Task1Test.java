package com.bootcamp.tw.p1;

import com.bootcamp.tw.p1.shapes.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void calculateAreaOfRectangle() {
        Rectangle rectangle = new Rectangle(12, 15);
        int area = rectangle.calculateArea();
        assertEquals(180, area);
    }
}