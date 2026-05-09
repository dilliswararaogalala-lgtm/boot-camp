package com.bootcamp.tw.p4;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Number> parkingSlots;
    private final int size;


    private ParkingLot(ArrayList<Number> slots, int size) {
        this.parkingSlots = slots;
        this.size = size;
    }

    public static ParkingLot create(int size) {
        ArrayList<Number> slots = new ArrayList<>();
        return new ParkingLot(slots, size);
    }

    public boolean park(Car car) {
        if(isFull()) return false;
        return car.park(this.parkingSlots);
    }

    public boolean isFull() {
        return this.parkingSlots.size() >= size;
    }
}
