package com.bootcamp.tw.p4;

public class ParkingLot {
    private final int parkingSlots;
    private int slotLeft;

    public ParkingLot(int size) {
        this.parkingSlots = size;
        this.slotLeft = size;
    }

    public int park(Car car) {
        int id = this.parkingSlots - this.slotLeft +1;
        car.park(id);
        this.slotLeft -= 1;
        return id;
    }

    public boolean isFull() {
        return slotLeft == 0;
    }
}
