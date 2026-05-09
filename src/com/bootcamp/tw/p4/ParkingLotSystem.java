package com.bootcamp.tw.p4;

import java.util.HashMap;

public class ParkingLotSystem {

    private final HashMap<String, ParkingLot> parkingLots = new HashMap<>();

    public void addParkingLot(String name, ParkingLot parkingLot) {
        parkingLots.put(name, parkingLot);
    }

    public boolean park(String name, Car car) {
        ParkingLot parkingLot = parkingLots.get(name);
        return parkingLot.park(car);
    }
}
