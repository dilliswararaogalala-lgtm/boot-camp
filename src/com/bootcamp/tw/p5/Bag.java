package com.bootcamp.tw.p5;

import java.util.LinkedHashMap;

public class Bag {

    private final int maxCapacity;
    private final LinkedHashMap<Color, Integer> ballsBag = new LinkedHashMap<>();
    private final Validator validator = new Validator();
    private int filled = 0;

    private Bag(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public static Bag createBag(int maxCapacity) throws InvalidInputException {
        if (maxCapacity < 0) {
            throw new InvalidCapacityInputException("Invalid Capacity");
        }
        return new Bag(maxCapacity);
    }

    public boolean add(Ball ball) throws InvalidInputException {
        if (filled >= maxCapacity) {
            throw new UnableToAddBallException("Bag is full");
        }

        validator.validateBallRatios(ballsBag, filled, ball);

        filled += 1;
        ball.addTo(ballsBag);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder summary = new StringBuilder();
        for (Color color : ballsBag.keySet()) {
            summary.append(padEnd(color.getValue(), 7)).append(": ").append(ballsBag.get(color)).append("\n");
        }

        summary.append("\n").append(padEnd("Total", 7)).append(": ").append(filled);
        return summary.toString();
    }

    private String padEnd(String value, int length) {
        return value + " ".repeat(length - value.length());
    }
}
