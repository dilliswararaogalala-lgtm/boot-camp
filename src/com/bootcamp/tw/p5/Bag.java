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
        if (maxCapacity < 0) {
            throw new InvalidCapacityInputException("Invalid Capacity");
        }
        return new Bag(maxCapacity);
    }

    public boolean add(Ball ball) throws UnableToAddBallException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        if (filled >= maxCapacity) {
            throw new UnableToAddBallException("Bag is full");
        }

        Integer greenBallCount = getBallCount(Color.GREEN);
        Integer redBallCount = getBallCount(Color.RED);
        boolean isGreen = ball.validate((color) -> color == Color.GREEN);
        boolean isRed = ball.validate((color) -> color == Color.RED);

        if (isGreen && greenBallCount >= 3) {
            throw new InvalidGreenBallStorageCountException("Bag contain 3 green balls Already");
        }

        if (isRed && greenBallCount * 2 <= redBallCount) {
            throw new InvalidGreenRedBallRatioException("Invalid green red ball ratio");
        }


        filled += 1;
        ball.addTo(ballsMap);
        return true;
    }

    public Integer getBallCount(Color color) {
        return ballsMap.getOrDefault(color, 0);
    }


}
