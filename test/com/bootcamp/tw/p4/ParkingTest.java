package com.bootcamp.tw.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {
    @Test
    void canParkACar() {
        Car car1 = new Car(1);
        ParkingLot parkingLot = ParkingLot.create(4);
        boolean isParked = parkingLot.park(car1);
        assertTrue( isParked);
    }

    @Test
    void shouldTellWhenParkingLotIsFull() {
        Car car1 = new Car(1);
        ParkingLot parkingLot = ParkingLot.create(1);

        boolean isParked = parkingLot.park(car1);
        assertTrue( isParked);
        assertTrue(parkingLot.isFull());
    }
}
