package com.bootcamp.tw.p1;


import com.bootcamp.tw.p1.shapes.Rectangle;
import jdk.jfr.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeTest {

    @Nested
    @Description("RECTANGLE")
    class RectangleTest {
        @Test
        @Description("Calculate the area of whole number size dimension")
        void calculateAreaOfRectangle() throws InvalidRectangleInput {
            Rectangle rectangle = Rectangle.createRectangle(12, 15);
            double area = rectangle.calculateArea();
            assertEquals(180, area, 1e-4);
        }

        @Test
        @Description("Calculate the area of floating number size dimension")
        void calculateAreaOfRectangleOfDecimalValues() throws InvalidRectangleInput {
            Rectangle rectangle = Rectangle.createRectangle(10.3, 13.4);
            double area = rectangle.calculateArea();
            assertEquals(138.02, area, 1e-4);
        }

        @Test
        @Description("Calculate the perimeter of whole number size dimension")
        void calculatePerimeter() throws InvalidRectangleInput {
            Rectangle rectangle = Rectangle.createRectangle(12, 24);
            double perimeter = rectangle.calculatePerimeter();
            assertEquals(72, perimeter);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithDecimalValues() throws InvalidRectangleInput {
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
        void calculateAreaOfSquare() throws InvalidRectangleInput {
            Rectangle square = Rectangle.createSquare(12);
            double area = square.calculateArea();
            assertEquals(144, area, 1e-4);
        }

        @Test
        @Description("Calculate the area of floating number size dimension")
        void calculateAreaOfSquareOfDecimalValues() throws InvalidRectangleInput {
            Rectangle square = Rectangle.createSquare(1.5);
            double area = square.calculateArea();
            assertEquals(2.25, area, 1e-4);
        }

        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithIntegerValues() throws InvalidRectangleInput {
            Rectangle square = Rectangle.createSquare(10);
            double perimeter = square.calculatePerimeter();
            assertEquals(40, perimeter);
        }


        @Test
        @Description("Calculate the perimeter of floating number size dimension")
        void calculatePerimeterWithDecimalValues() throws InvalidRectangleInput {
            Rectangle square = Rectangle.createSquare(10.5);
            double perimeter = square.calculatePerimeter();
            assertEquals(42, perimeter);
        }

        @Test
        @Description("Throws the error for invalid input arguments to create rectangle")
        void shouldThrowErrorForInvalidArgument() {
            assertThrows(InvalidRectangleInput.class, () -> Rectangle.createRectangle(-1, 2));
            assertThrows(InvalidRectangleInput.class, () -> Rectangle.createRectangle(-1, -2));
            assertThrows(InvalidRectangleInput.class, () -> Rectangle.createRectangle(1, -2));
            assertThrows(InvalidRectangleInput.class, () -> Rectangle.createRectangle(0, 1));
        }

        @Test
        @Description("Throws the error for invalid input arguments to create square")
        void shouldThrowErrorForInvalidArgumentToCreateSquare() {
            assertThrows(InvalidRectangleInput.class, () -> Rectangle.createSquare(-1));
            assertThrows(InvalidRectangleInput.class, () -> Rectangle.createSquare(0));
        }
    }
}