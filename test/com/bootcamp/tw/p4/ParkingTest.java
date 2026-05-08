package com.bootcamp.tw.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {

    @Test
    void canParkACar() {
        Car car1 = new Car(1);
        ParkingLot parkingLot = new ParkingLot(4);
        int slotId = parkingLot.park(car1);
        assertEquals(1, slotId);
    }

    @Test
    void shouldTellWhenParkingLotIsFull() {
        Car car1 = new Car(1);
        ParkingLot parkingLot = new ParkingLot(1);
        int slotId = parkingLot.park(car1);
        assertEquals(1, slotId);
        assertTrue(parkingLot.isFull());
    }
}
