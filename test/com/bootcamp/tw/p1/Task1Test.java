package com.bootcamp.tw.p1;

import com.bootcamp.tw.p1.shapes.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void calculateAreaOfRectangle() {
        Rectangle rectangle = new Rectangle(12, 15);
        double area = rectangle.calculateArea();
        assertEquals(180, area, 1e-4);
    }

    @Test
    void calculateAreaOfRectangleOfDecimalValues() {
        Rectangle rectangle = new Rectangle(10.3, 13.4);
        double area = rectangle.calculateArea();
        assertEquals(138.02, area, 1e-4);
    }

    @Test
    void calculatePerimeter() {
        Rectangle rectangle = new Rectangle(12, 24);
        double perimeter = rectangle.calculatePerimeter();
        assertEquals(72, perimeter);
    }

    @Test
    void calculatePerimeterWithDecimalValues() {
        Rectangle rectangle = new Rectangle(12.5, 24.5);
        double perimeter = rectangle.calculatePerimeter();
        assertEquals(74, perimeter);
    }

    @Test
    void createRectangle() {
        Rectangle rectangle = Rectangle.create(12.2, 12.2);
        Rectangle expectedRectangle = new Rectangle(12.2, 12.2);
        assertEquals(expectedRectangle, rectangle);
    }

}