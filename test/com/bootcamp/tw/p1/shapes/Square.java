package com.bootcamp.tw.p1.shapes;

public class Square {
    private final double side;

    public Square(double side) {
        this.side = side;
    }


    public double calculateArea() {
        return side * side;
    }
}
