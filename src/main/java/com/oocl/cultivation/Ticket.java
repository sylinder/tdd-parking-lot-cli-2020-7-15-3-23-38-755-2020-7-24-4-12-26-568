package com.oocl.cultivation;

public class Ticket {
    public static int increaseNumber = 1;

    private int id;

    public Ticket() {
        this.id = increaseNumber++;
    }

    public int getId() {
        return id;
    }
}
