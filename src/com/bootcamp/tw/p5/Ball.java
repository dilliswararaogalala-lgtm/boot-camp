package com.bootcamp.tw.p5;

import java.util.HashMap;
import java.util.function.Predicate;

public class Ball {
    private final Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public void addTo(HashMap<Color, Integer> ballsMap) {
        Integer previousCount = ballsMap.getOrDefault(this.color, 0) ;
        ballsMap.put(this.color, previousCount + 1);
    }

    public boolean validate(Predicate<Color> p) {
        return p.test(this.color);
    }
}
