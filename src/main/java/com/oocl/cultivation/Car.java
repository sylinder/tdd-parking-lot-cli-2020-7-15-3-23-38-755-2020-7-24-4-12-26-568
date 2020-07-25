package com.oocl.cultivation;

public class Car {
    private static int increaseNumber = 10;

    private int id;

    private String returningMessage;

    public void setReturningMessage(String returningMessage) {
        this.returningMessage = returningMessage;
    }

    public String getReturningMessage() {
        return returningMessage;
    }

    public Car() {
        this.id = increaseNumber++;
    }

    public int getId() {
        return id;
    }
}
