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


    /**
     * given: ticket
     * when: parking
     * then: return a car
     */

    @Test
    public void should_return_car_when_parking_given_ticket() {
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = parkingBoy.fetchCar(ticket);
        Assertions.assertNotNull(car);
    }

}