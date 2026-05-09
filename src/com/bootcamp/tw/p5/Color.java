package com.bootcamp.tw.p5;

public enum Color {
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    YELLOW("Yellow");

    private final String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    public String getValue() {
        return colorName;
    }
}
