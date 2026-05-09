package com.bootcamp.tw.p4;

import java.util.HashMap;

public class View {
    private final HashMap<String, ParkingLot> parkingLots;

    public View(HashMap<String, ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String viewStatus() {
        StringBuilder view = new StringBuilder();
        for (String name : parkingLots.keySet()) {
            ParkingLot parkingLot = parkingLots.get(name);

            String status = parkingLot.isFull() ? "FULL" : "AVAILABLE";
            view.append(name).append(": ").append(status).append("\n");
        }

        return view.toString();
    }

    public double occupiedPercentage(String parkingLotName) {
        ParkingLot parkingLot = parkingLots.get(parkingLotName);
        return parkingLot.percentageCovered();
    }
}
