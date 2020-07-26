package com.oocl.cultivation;

public class ParkingLot {
    private static final int totalPostion = 10;
    private int remainPosition;

    public ParkingLot() {
        this.remainPosition = totalPostion;
    }

    public int getRemainPosition() {
        return remainPosition;
    }

    public void setRemainPosition(int remainPosition) {
        this.remainPosition = remainPosition;
    }

    public void decreasePostion() {
        this.remainPosition--;
    }
}
