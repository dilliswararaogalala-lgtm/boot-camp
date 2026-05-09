package com.bootcamp.tw.p5;

import java.util.HashMap;

public class Bag {

    private final int maxCapacity;
    private final HashMap<Color, Integer> ballsMap = new HashMap<>();
    private int filled = 0;

    private Bag(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public static Bag createBag(int maxCapacity) throws InvalidCapacityInputException {
        if(maxCapacity < 0){
            throw new InvalidCapacityInputException("Invalid Capacity");
        }
        return new Bag(maxCapacity);
    }

    public boolean add(Ball ball) throws UnableToAddBallException {
        if (filled >= maxCapacity){
            throw new UnableToAddBallException("Bag is full");
        }
        filled += 1;
        ball.addTo(ballsMap);
        return true;
    }


}
