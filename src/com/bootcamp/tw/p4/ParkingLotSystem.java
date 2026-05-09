package com.bootcamp.tw.p4;

import java.util.HashMap;

public class ParkingLotSystem {

    private final HashMap<String, ParkingLot> parkingLots = new HashMap<>();

    public void addParkingLot(String name, ParkingLot parkingLot) throws ParkingLotNameAlreadyExistException {
        if (parkingLots.containsKey(name)){
            throw new ParkingLotNameAlreadyExistException("Name Already Exists");
        }
        parkingLots.put(name, parkingLot);
    }

    public boolean park(String name, Car car) throws InvalidParkingLotNameException {
        if(!parkingLots.containsKey(name)){
            throw  new InvalidParkingLotNameException("Parking lot is not available");
        }
        ParkingLot parkingLot = parkingLots.get(name);
        return parkingLot.park(car);
    }
}
