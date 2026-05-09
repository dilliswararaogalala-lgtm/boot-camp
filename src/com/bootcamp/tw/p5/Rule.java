package com.bootcamp.tw.p5;

import java.util.HashMap;
import java.util.function.BiPredicate;

public enum Rule {
    validateGreenBallRatio((HashMap<Color, Integer> ballsBag, Ball ball) -> {
        int greenBallCount = getBallCount(ballsBag, Color.GREEN);
        boolean isGreen = isRequiredColor(ball, Color.GREEN);
        return !isGreen || greenBallCount < 3;
    }, new InvalidGreenBallStorageCountException("Bag contain 3 green balls Already")),

    validateRedGreenRatio((HashMap<Color, Integer> ballsBag, Ball ball) -> {
        int greenBallCount = getBallCount(ballsBag, Color.GREEN);
        boolean isRed = isRequiredColor(ball, Color.RED);
        int redBallCount = getBallCount(ballsBag, Color.RED);
        return !isRed || greenBallCount * 2 > redBallCount;
    }, new InvalidGreenRedBallRatioException("Invalid green red ball ratio")),

    validateYellowBallRatio((HashMap<Color, Integer> ballsBag, Ball ball) -> {
        int yellowBallCount = getBallCount(ballsBag, Color.YELLOW);
        boolean isYellow = isRequiredColor(ball, Color.YELLOW);
        return !isYellow || (!((yellowBallCount + 1.0) / (getTotalBallAdded(ballsBag) + 1) > 0.4));
    }, new InvalidYellowBallRatioException("Yellow Balls can not be more than 40% of added balls"));

    private final BiPredicate<HashMap<Color, Integer>, Ball> predicate;
    private final InvalidInputException exception;

    Rule(BiPredicate<HashMap<Color, Integer>, Ball> predicate, InvalidInputException e) {
        this.predicate = predicate;
        this.exception = e;
    }

    void validate(HashMap<Color, Integer> bag, Ball ball) throws InvalidInputException {
         if (!this.predicate.test(bag, ball)){
             throw this.exception;
         }
    }

    private static int getBallCount(HashMap<Color, Integer> ballsBag, Color color) {
        return ballsBag.getOrDefault(color, 0);
    }

    private static boolean isRequiredColor(Ball ball, Color targetedColor) {
        return ball.validate((color) -> color == targetedColor);
    }

    private static int getTotalBallAdded(HashMap<Color, Integer> ballsBag) {
        int balls = 0;
        for (Color color: ballsBag.keySet()){
            balls += ballsBag.get(color);
        }
        return balls;
    }
}
