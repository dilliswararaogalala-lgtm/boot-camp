package com.bootcamp.tw.p4;

import java.util.ArrayList;

public class Car {
    private final int id;

    public Car(int id) {
        this.id = id;
    }

    public boolean park(ArrayList<Number> parkingSlots) {
        return parkingSlots.add(id);
    }
}
