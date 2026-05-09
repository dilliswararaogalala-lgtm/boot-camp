package com.bootcamp.tw.p5;

import java.util.HashMap;

public class Validator {
    public void validateBallRatios(HashMap<Color, Integer> ballsBag, int filled, Ball ball) throws InvalidInputException {
        validateGreenBallRatio(ballsBag, ball);
        validateRedGreenRatio(ballsBag, ball);
        validateYellowBallRatio(ballsBag, filled, ball);
    }

    private void validateYellowBallRatio(HashMap<Color, Integer> ballsBag, int filled, Ball ball) throws InvalidYellowBallRatioException {
        int yellowBallCount = getBallCount(ballsBag, Color.YELLOW);
        boolean isYellow = isRequiredColor(ball, Color.YELLOW);
        if (isYellow && ((yellowBallCount + 1.0) / (filled + 1) > 0.4)) {
            throw new InvalidYellowBallRatioException("Yellow Balls can not be more than 40% of added balls");
        }
    }

    private void validateRedGreenRatio(HashMap<Color, Integer> ballsBag, Ball ball) throws InvalidGreenRedBallRatioException {
        int greenBallCount = getBallCount(ballsBag, Color.GREEN);
        boolean isRed = isRequiredColor(ball, Color.RED);
        int redBallCount = getBallCount(ballsBag, Color.RED);
        if (isRed && greenBallCount * 2 <= redBallCount) {
            throw new InvalidGreenRedBallRatioException("Invalid green red ball ratio");
        }
    }

    private void validateGreenBallRatio(HashMap<Color, Integer> ballsBag, Ball ball) throws InvalidGreenBallStorageCountException {
        int greenBallCount = getBallCount(ballsBag, Color.GREEN);
        boolean isGreen = isRequiredColor(ball, Color.GREEN);
        if (isGreen && greenBallCount >= 3) {
            throw new InvalidGreenBallStorageCountException("Bag contain 3 green balls Already");
        }
    }

    private boolean isRequiredColor(Ball ball, Color targetedColor) {
        return ball.validate((color) -> color == targetedColor);
    }

    private int getBallCount(HashMap<Color, Integer> ballsBag, Color color) {
        return ballsBag.getOrDefault(color, 0);
    }
}