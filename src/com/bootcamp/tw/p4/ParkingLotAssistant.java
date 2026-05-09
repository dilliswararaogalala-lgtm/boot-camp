package com.bootcamp.tw.p4;

public class ParkingLotAssistant {
    private final ParkingLotSystem parkingLotSystem;

    public ParkingLotAssistant(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    public String view() {
        return parkingLotSystem.getLotsState();
    }
}
