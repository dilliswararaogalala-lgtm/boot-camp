package com.bootcamp.tw.p4;

public class Car {
    private final int id;
    private Integer parkedAt;

    public Car(int id) {
        this.id = id;
        this.parkedAt = null;
    }

    public void park(int id) {
        parkedAt = id;
    }
}
