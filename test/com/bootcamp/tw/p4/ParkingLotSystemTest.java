package com.bootcamp.tw.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotSystemTest {
    @Test
    void createParkingLotInParkingLotSystemAndAllowsToParkACar() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        ParkingLot parkingLot = ParkingLot.create(10);
        Car car = new Car(1);
        parkingLotSystem.addParkingLot("P1", parkingLot);
        boolean isParked = parkingLotSystem.park("P1", car);
        assertTrue(isParked);
    }

}
