package com.bootcamp.tw.p5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class Bag {

    private final int maxCapacity;
    private final LinkedHashMap<Color, Integer> ballsBag = new LinkedHashMap<>();
    private final Validator validator;
    private int filled = 0;

    public Bag(int maxCapacity, Validator validator) {
        this.maxCapacity = maxCapacity;
        this.validator = validator;
    }


    public static Bag createBag(int maxCapacity) throws InvalidInputException {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(Rule.validateGreenBallRatio);
        rules.add(Rule.validateRedGreenRatio);
        rules.add(Rule.validateYellowBallRatio);

        return createBagWithRules(maxCapacity, rules);
    }

    public static Bag createBagWithRules(int maxCapacity, ArrayList<Rule> rules) throws InvalidCapacityInputException {
        if (maxCapacity < 0) {
            throw new InvalidCapacityInputException("Invalid Capacity");
        }
        Validator validator = new Validator(rules);
        return new Bag(maxCapacity, validator);
    }

    public boolean add(Ball ball) throws InvalidInputException {
        if (filled >= maxCapacity) {
            throw new UnableToAddBallException("Bag is full");
        }

        validator.validateRules(ballsBag, ball);

        filled += 1;
        ball.addTo(ballsBag);
        return true;
    }

    @Override
    public String toString() {
        int maxLength = getMaxLength(ballsBag.keySet()) + 1;
        StringBuilder summary = new StringBuilder();
        for (Color color : ballsBag.keySet()) {
            summary.append(padEnd(color.getValue(), maxLength)).append(": ").append(ballsBag.get(color)).append("\n");
        }

        summary.append("\n").append(padEnd("Total", maxLength)).append(": ").append(filled);
        return summary.toString();
    }

    private int getMaxLength(Set<Color> colors) {
        int max = 0;
        for (Color color : colors) {
            int colorStringLength = color.toString().length();
            max = Math.max(max, colorStringLength);
        }
        return max;
    }

    private String padEnd(String value, int length) {
        return value + " ".repeat(length - value.length());
    }
}
