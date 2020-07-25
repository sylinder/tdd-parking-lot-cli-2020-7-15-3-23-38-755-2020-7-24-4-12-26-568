package com.oocl.cultivation;

public class Customer {

    public String queryForErrorMessage(Ticket ticket, ParkingBoy parkingBoy) {
        return parkingBoy.response(ticket);
    }
}
