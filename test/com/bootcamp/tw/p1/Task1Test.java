package com.bootcamp.tw.p1;


import com.bootcamp.tw.p1.shapes.Rectangle;
import com.bootcamp.tw.p1.shapes.Square;
import jdk.jfr.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Nested
    @Description("RECTANGLE")
    class RectangleTest {
        @Test
        @Description("Calculate the area of whole number size dimension")
        void calculateAreaOfRectangle() {
            Rectangle rectangle = new Rectangle(12, 15);
            double area = rectangle.calculateArea();
            assertEquals(180, area, 1e-4);
        }

        @Test
        @Description("Calculate the area of floating number size dimension")
        void calculateAreaOfRectangleOfDecimalValues() {
            Rectangle rectangle = new Rectangle(10.3, 13.4);
            double area = rectangle.calculateArea();
            assertEquals(138.02, area, 1e-4);
        }

        @Test
        @Description("Calculate the perimeter of whole number size dimension")
        void calculatePerimeter() {
            Rectangle rectangle = new Rectangle(12, 24);
            double perimeter = rectangle.calculatePerimeter();
            assertEquals(72, perimeter);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
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

    @Nested
    @Description("SQUARE")
    class SquareTest{
        @Test
        @Description("Calculate the area of whole number size dimension")
        void calculateAreaOfSquare() {
            Square rectangle = new Square(12);
            double area = rectangle.calculateArea();
            assertEquals(144, area, 1e-4);
        }

        @Test
        @Description("Calculate the area of floating number size dimension")
        void calculateAreaOfSquareOfDecimalValues() {
            Square rectangle = new Square(1.5);
            double area = rectangle.calculateArea();
            assertEquals(2.25, area, 1e-4);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithIntegerValues() {
            Square square = new Square(10);
            double perimeter = square.calculatePerimeter();
            assertEquals(40, perimeter);
        }

        @Test
        @Description("Square provides static method to create a square")
        void createSquare() {
            Square square = Square.create(12.2);
            Square expectedRectangle = new Square(12.2);
            assertEquals(expectedRectangle, square);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithDecimalValues() {
            Square square = new Square(10.5);
            double perimeter = square.calculatePerimeter();
            assertEquals(42, perimeter);
        }
    }
}