package com.bootcamp.tw.p4;

public class Manager implements Viewer {
    private final String parkingLotName;
    private double percentage;

    public Manager(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    @Override
    public void updateView(View view) {
       this.percentage = view.occupiedPercentage(parkingLotName);
    }

    public boolean canAllowTrainee() {
        return this.percentage < 80;
    }
}
