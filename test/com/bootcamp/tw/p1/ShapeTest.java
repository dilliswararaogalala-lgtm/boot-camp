package com.bootcamp.tw.p1;


import com.bootcamp.tw.p1.shapes.Rectangle;
import jdk.jfr.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Nested
    @Description("RECTANGLE")
    class RectangleTest {
        @Test
        @Description("Calculate the area of whole number size dimension")
        void calculateAreaOfRectangle() {
            Rectangle rectangle = Rectangle.createRectangle(12, 15);
            double area = rectangle.calculateArea();
            assertEquals(180, area, 1e-4);
        }

        @Test
        @Description("Calculate the area of floating number size dimension")
        void calculateAreaOfRectangleOfDecimalValues() {
            Rectangle rectangle = Rectangle.createRectangle(10.3, 13.4);
            double area = rectangle.calculateArea();
            assertEquals(138.02, area, 1e-4);
        }

        @Test
        @Description("Calculate the perimeter of whole number size dimension")
        void calculatePerimeter() {
            Rectangle rectangle = Rectangle.createRectangle(12, 24);
            double perimeter = rectangle.calculatePerimeter();
            assertEquals(72, perimeter);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithDecimalValues() {
            Rectangle rectangle = Rectangle.createRectangle(12.5, 24.5);
            double perimeter = rectangle.calculatePerimeter();
            assertEquals(74, perimeter);
        }
    }

    @Nested
    @Description("SQUARE")
    class SquareTest{
        @Test
        @Description("Calculate the area of whole number size dimension")
        void calculateAreaOfSquare() {
            Rectangle square = Rectangle.createSquare(12);
            double area = square.calculateArea();
            assertEquals(144, area, 1e-4);
        }

        @Test
        @Description("Calculate the area of floating number size dimension")
        void calculateAreaOfSquareOfDecimalValues() {
            Rectangle square = Rectangle.createSquare(1.5);
            double area = square.calculateArea();
            assertEquals(2.25, area, 1e-4);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithIntegerValues() {
            Rectangle square = Rectangle.createSquare(10);
            double perimeter = square.calculatePerimeter();
            assertEquals(40, perimeter);
        }


        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithDecimalValues() {
            Rectangle square = Rectangle.createSquare(10.5);
            double perimeter = square.calculatePerimeter();
            assertEquals(42, perimeter);
        }
    }
}