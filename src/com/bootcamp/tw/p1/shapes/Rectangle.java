package com.bootcamp.tw.p1.shapes;

import com.bootcamp.tw.p1.InvalidRectangleInput;

import java.util.Objects;

public class Rectangle {
    private final double length;
    private final double width;

    private Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle createRectangle(double length, double width) throws InvalidRectangleInput {
        if (length <= 0 || width <= 0){
            throw new InvalidRectangleInput("Invalid length or width");
        }
        return new Rectangle(length, width);
    }

    public static Rectangle createSquare(double side) throws InvalidRectangleInput {
        return Rectangle.createRectangle(side, side);
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(length, rectangle.length) == 0 && Double.compare(width, rectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
