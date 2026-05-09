package com.bootcamp.tw.p5;

import java.util.HashMap;

public class Bag {

    private final int maxCapacity;
    private final HashMap<Color, Integer> ballsBag = new HashMap<>();
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

}
