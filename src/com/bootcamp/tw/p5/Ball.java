package com.bootcamp.tw.p5;

import java.util.HashMap;

public class Ball {
    private final Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public void addTo(HashMap<Color, Integer> ballsMap) {
        Integer count = ballsMap.get(this.color) == null ?   1:ballsMap.get(this.color) + 1;
        ballsMap.put(this.color, count);
    }
}
