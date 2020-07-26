package com.oocl.cultivation;

public class ParkingLot {
    private static final int DEFAULT_TOTAL_POSITION = 10;
    private int remainPosition;
    private int totalPosition;

    public ParkingLot() {
        this.totalPosition = DEFAULT_TOTAL_POSITION;
        this.remainPosition = DEFAULT_TOTAL_POSITION;
    }

    public ParkingLot(int totalPosition) {
        this.totalPosition = totalPosition;
        this.remainPosition = totalPosition;
    }

    public int getRemainPosition() {
        return remainPosition;
    }

    public void setRemainPosition(int remainPosition) {
        this.remainPosition = remainPosition;
    }

    public int getTotalPosition() {
        return totalPosition;
    }

    public void setTotalPosition(int totalPosition) {
        this.totalPosition = totalPosition;
    }

    public void decreasePostion() {
        this.remainPosition--;
    }
}
