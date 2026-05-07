package com.bootcamp.tw.p1.shapes;

import java.util.Objects;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public static Square create(double side) {
        return new Square(side);
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return side * 4;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(side, square.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(side);
    }
}
