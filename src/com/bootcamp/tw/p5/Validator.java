package com.bootcamp.tw.p5;

import java.util.ArrayList;
import java.util.HashMap;

public class Validator {
    private final ArrayList<Rule> rules;

    public Validator(ArrayList<Rule> rules) {
        this.rules = rules;
    }


    public void validateRules(HashMap<Color, Integer> ballsBag, Ball ball) throws InvalidInputException {
        for (Rule rule : rules){
            rule.validate(ballsBag, ball);
        }
    }
}