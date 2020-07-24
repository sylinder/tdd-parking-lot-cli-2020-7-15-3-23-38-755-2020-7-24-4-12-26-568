package com.oocl.cultivation;

public class Car {
    private static int increaseNumber = 10;

    private int id;

    public Car() {
        this.id = increaseNumber++;
    }

    public int getId() {
        return id;
    }
}
