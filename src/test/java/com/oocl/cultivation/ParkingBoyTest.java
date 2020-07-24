package com.oocl.cultivation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    /**
     * given: a car
     * when: parkingboy parking car
     * then: return a ticket
     */

    @Test
    void should_return_ticket_when_parking_given_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Assertions.assertNotNull(ticket);
    }


    /**
     * given: a ticket
     * when: parking boy parking car
     * then: return a correspond car
     */

    @Test
    public void should_return_car_when_parking_given_ticket() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Car returnCar = parkingBoy.fetchCar(ticket);
        Assertions.assertEquals(car.getId(), returnCar.getId());
    }

    /**
     * given:  2 cars
     * when: parking boy parking car
     * then: return 2 ticket
     */
    @Test
    public void should_return_2_tickets_when_parking_given_2_cars() {
        LinkedList<Car> cars = new LinkedList<>();
        for (int index = 0; index < 2; index++) {
            cars.add(new Car());
        }
        ParkingBoy parkingBoy = new ParkingBoy();
        LinkedList<Ticket> tickets = parkingBoy.park(cars);
        Assertions.assertEquals(2, tickets.size());
    }


    /**
     * given: a ticket
     * when: parking boy fetch car by ticket
     * then: return a correspond car
     */

    // already meet requirement




    /**
     * given: a wrong ticket
     * when: parking boy fetch car by ticket
     * then: return null and a warning message
     */
    @Test
    public void should_return_null_when_parking_given_wrong_ticket() {
        Ticket wrongTicket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = parkingBoy.fetchCar(wrongTicket);
        Assertions.assertEquals(null, car);
    }


    /**
     * given: a ticket already used
     * when: parking boy fetch car
     * then: return null and a warning message
     */


    /**
     * given: no position, a car
     * when: parking boy parking car
     * then: return null and a sorry message.
     */



}