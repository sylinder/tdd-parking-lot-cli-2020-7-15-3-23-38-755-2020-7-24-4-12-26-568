package com.oocl.cultivation;

public class Customer {

    public String queryForErrorMessage(Ticket ticket) {
        ParkingBoy parkingBoy = new ParkingBoy();
        return parkingBoy.response(ticket);
    }
}
