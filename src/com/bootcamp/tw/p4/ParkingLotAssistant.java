package com.bootcamp.tw.p4;

public class ParkingLotAssistant {
    private String status;

    public ParkingLotAssistant(String status) {
        this.status = status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String view() {
        return status;
    }
}
