package com.bootcamp.tw.p4;

import java.util.HashMap;

public class ParkingLotSystem {

    private final HashMap<String, ParkingLot> parkingLots = new HashMap<>();

    public void addParkingLot(String name, ParkingLot parkingLot) throws ParkingLotNameAlreadyExistException {
        if (isParkingLotExist(name)) {
            throw new ParkingLotNameAlreadyExistException("Name Already Exists");
        }
        parkingLots.put(name, parkingLot);
    }

    private boolean isParkingLotExist(String name) {
        return parkingLots.containsKey(name);
    }

    public boolean park(String name, Car car) throws InvalidParkingLotNameException {
        if (!isParkingLotExist(name)) {
            throw new InvalidParkingLotNameException("Parking lot is not available");
        }
        ParkingLot parkingLot = parkingLots.get(name);
        return parkingLot.park(car);
    }

    public boolean isFull(String name) {
        ParkingLot parkingLot = parkingLots.get(name);
        return parkingLot.isFull();
    }

    public String getLotsState() {
        StringBuilder view = new StringBuilder();
        for (String name : parkingLots.keySet()) {
            ParkingLot parkingLot = parkingLots.get(name);

            String status = parkingLot.isFull() ? "FULL" : "AVAILABLE";
            view.append(name).append(": ").append(status).append("\n");
        }

        return view.toString();
    }
}
