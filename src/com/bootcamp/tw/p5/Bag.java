package com.bootcamp.tw.p5;

import java.util.ArrayList;

public class Bag {
    private final ArrayList<Ball> balls = new ArrayList<>();
    private final int maxCapacity;

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
        if (balls.size() >= maxCapacity){
            throw new UnableToAddBallException("Bag is full");
        }
        balls.add(ball);
        return true;
    }
}
