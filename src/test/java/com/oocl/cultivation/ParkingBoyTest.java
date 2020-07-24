package com.oocl.cultivation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parking_given_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Assertions.assertNotNull(ticket);
    }

}