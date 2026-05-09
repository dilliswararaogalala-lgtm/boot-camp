package com.bootcamp.tw.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotSystemTest {
    @Test
    void createParkingLotInParkingLotSystemAndAllowsToParkACar() throws ParkingLotNameAlreadyExistException, InvalidParkingLotNameException {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        ParkingLot parkingLot = ParkingLot.create(10);
        Car car = new Car(1);
        parkingLotSystem.addParkingLot("P1", parkingLot);
        boolean isParked = parkingLotSystem.park("P1", car);
        assertTrue(isParked);
    }

    @Test
    void shouldThrowAnErrorIfTryToCreateSameParkingLot() throws ParkingLotNameAlreadyExistException {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        ParkingLot parkingLot = ParkingLot.create(10);
        parkingLotSystem.addParkingLot("P1", parkingLot);
        assertThrows(ParkingLotNameAlreadyExistException.class, () -> parkingLotSystem.addParkingLot("P1", parkingLot));
    }

    @Test
    void shouldTellIfGivenParkingLotIsFullOrNot() throws ParkingLotNameAlreadyExistException, InvalidParkingLotNameException {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        ParkingLot parkingLot = ParkingLot.create(1);
        Car car = new Car(1);
        parkingLotSystem.addParkingLot("P1", parkingLot);
        boolean isParked = parkingLotSystem.park("P1", car);
        boolean isParkedLotFull = parkingLotSystem.isFull("P1");
        assertTrue(isParked);
        assertTrue(isParkedLotFull);
    }

    @Test
    void shouldReturnFalseWhenAttendantParkInWhenParkingLotIsFull() throws ParkingLotNameAlreadyExistException, InvalidParkingLotNameException {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        ParkingLot parkingLot = ParkingLot.create(1);
        Car ferrari = new Car(1);
        Car lamborghini = new Car(1);
        parkingLotSystem.addParkingLot("P1", parkingLot);
        boolean isFerrariParked = parkingLotSystem.park("P1", ferrari);
        boolean isLamborghiniParked = parkingLotSystem.park("P1", lamborghini);
        assertTrue(isFerrariParked);
        assertFalse(isLamborghiniParked);
    }

    @Test
    void shouldThrowAnErrorIfTryToParkOnInvalidParkingLotName()  {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Car car = new Car(1);
        assertThrows(InvalidParkingLotNameException.class,()->parkingLotSystem.park("P1", car));
    }

    @Test
    void shouldCreateNewAssistantHowCanViewTheDisplay() throws ParkingLotNameAlreadyExistException, InvalidParkingLotNameException {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        ParkingLot parkingLot = ParkingLot.create(2);
        parkingLotSystem.addParkingLot("P1", parkingLot);
        Car car = new Car(1);
        Car car2 = new Car(2);
        parkingLotSystem.park("P1", car);

        ParkingLotAssistant parkingLotAssistant = new ParkingLotAssistant("");
        parkingLotSystem.addNewAssistant(parkingLotAssistant);

        assertEquals( "P1: AVAILABLE\n", parkingLotAssistant.view());
        parkingLotSystem.park("P1", car2);
        assertTrue(parkingLotSystem.isFull("P1"));
        assertEquals( "P1: FULL\n", parkingLotAssistant.view());
    }

}
