package com.bootcamp.tw.p5;

import java.util.HashMap;

public class Bag {

    private final int maxCapacity;
    private final HashMap<Color, Integer> ballsMap = new HashMap<>();
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

        Integer greenBallCount = getBallCount(Color.GREEN);
        Integer redBallCount = getBallCount(Color.RED);
        Integer yellowBallCount = getBallCount(Color.YELLOW);
        boolean isGreen = isRequiredColor(ball, Color.GREEN);
        boolean isRed = isRequiredColor(ball, Color.RED);
        boolean isYellow = isRequiredColor(ball, Color.YELLOW);

        if (isGreen && greenBallCount >= 3) {
            throw new InvalidGreenBallStorageCountException("Bag contain 3 green balls Already");
        }

        if (isRed && greenBallCount * 2 <= redBallCount) {
            throw new InvalidGreenRedBallRatioException("Invalid green red ball ratio");
        }

        if(isYellow && ((yellowBallCount + 1.0) / (filled + 1) > 0.4)){
            throw new InvalidYellowBallRatioException("Yellow Balls can not be more than 40% of added balls");
        }

        filled += 1;
        ball.addTo(ballsMap);
        return true;
    }

    public static boolean isRequiredColor(Ball ball, Color targetedColor) {
        return ball.validate((color) -> color == targetedColor);
    }

    public Integer getBallCount(Color color) {
        return ballsMap.getOrDefault(color, 0);
    }


}
