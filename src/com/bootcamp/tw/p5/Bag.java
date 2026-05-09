package com.bootcamp.tw.p5;

import java.util.ArrayList;

public class Bag {
    private final ArrayList<Ball> balls = new ArrayList<>();

    public boolean add(Ball ball) throws UnableToAddBallException {
        if (balls.size() >= 12){
            throw new UnableToAddBallException("Bag is full");
        }
        balls.add(ball);
        return true;
    }
}
