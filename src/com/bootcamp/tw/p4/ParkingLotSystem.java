package com.bootcamp.tw.p4;

import java.util.HashMap;

public class ParkingLotSystem {

    private final HashMap<String, ParkingLot> parkingLots = new HashMap<>();
    private Viewer viewer;

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

        boolean isParked = parkingLot.park(car);
        updateViewer();
        return isParked;
    }

    private void updateViewer() {
        if(viewer != null){
            this.viewer.updateView(new View(parkingLots));
        }
    }

    public boolean isFull(String name) {
        ParkingLot parkingLot = parkingLots.get(name);
        return parkingLot.isFull();
    }


    public void addViewer(Viewer viewer) {
        this.viewer = viewer;
        viewer.updateView(new View(parkingLots));
    }
}
