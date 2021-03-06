package com.oocl.cultivation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    /**
     * given: a car
     * when: parking boy parking car
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
        Assertions.assertEquals(null, car);  //already meet the requirement
    }


    /**
     * given: a ticket already used
     * when: parking boy fetch car
     * then: return null and a warning message
     */

    @Test
    public void should_return_null_when_parking_given_used_ticket() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetchCar(ticket);
        Car wrongCar = parkingBoy.fetchCar(ticket);
        Assertions.assertNull(wrongCar);
    }


    /**
     * given: no position, a car
     * when: parking boy parking car
     * then: return null and a sorry message.
     */

    @ Test
    public void should_return_null_when_parking_given_car_and_remain_zero_position() {
//        int remainPosition = 0;
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedList<>());
//        parkingBoy.setRemainPosition(0);
        Ticket ticket = parkingBoy.park(car);
        Assertions.assertNull(ticket);
    }

    /**
     * given: a parked car
     * when: parking boy parking car
     * then: return null
     */
    @Test
    public void should_return_null_when_parking_given_parked_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Ticket anotherTicket = parkingBoy.park(car);
        Assertions.assertNull(anotherTicket);
    }

    /**
     * given: a null car
     * when: parking boy parking car
     * then: return null
     */
    @Test
    public void should_return_null_when_parking_given_null_car() {
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Assertions.assertNull(ticket);
    }

    //==============Story 2=======================

    @Test
    public void should_return_unrecognized_ticket_when_parking_given_wrong_ticket() {
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        Customer customer = new Customer();
        Car car = parkingBoy.fetchCar(ticket);
        Assertions.assertNull(car);
        String response = customer.queryForErrorMessage(ticket, parkingBoy);
        Assertions.assertEquals("Unrecognized parking ticket", response);
    }

    /**
     * given: customer provide null ticket
     * when: parking boy parking car
     * then: return error message notify provide ticket
     */
    @Test
    public void should_return_notify_message_when_parking_given_null_ticket() {
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        Customer customer = new Customer();
        Car car = parkingBoy.fetchCar(ticket);
        Assertions.assertNull(car);
        String errorMessage = customer.queryForErrorMessage(ticket, parkingBoy);
        Assertions.assertEquals("Please provide your parking ticket.", errorMessage);
    }

    /**
     * given: zero position
     * when: parking boy parking car
     * then: return error message not enough position
     */

    @Test
    public void should_return_not_enough_position_when_paring_given_zero_position() {
//        int remainPosition = 0;
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new LinkedList<>());
//        parkingBoy.setRemainPosition(0);
        Ticket ticket = parkingBoy.park(car);
        Assertions.assertNull(ticket);
        String errorMessage = new Customer().queryForErrorMessage(ticket, parkingBoy);
        Assertions.assertEquals("Not enough position.", errorMessage);
    }


    //==============Story 3================

    /**
     * given: 2 parking lots
     * when: parking boy parking car
     * then: return one parking lot is full is another is empty
     */

    @Test
    public void should_return_one_full_another_empty_when_parking_given_two_parking_lots() {
        LinkedList<ParkingLot> parkingLots = new LinkedList<ParkingLot>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int index = 0; index < 10; index++) {
            parkingBoy.park(new Car());
        }
        Assertions.assertEquals(0, parkingLots.get(0).getRemainPosition());
        Assertions.assertEquals(10, parkingLots.get(1).getRemainPosition());
    }



    //===============Story 4===================

    /**
     * given: 2 parking lot with different empty position
     * when: smart parking boy parking car
     * then: return park car to the parking car with more empty position
     */

    @Test
    public void should_return_decrease_position_with_more_empty_position_parkingLot_when_parking_given_two_different_empty_position() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        firstParkingLot.setRemainPosition(3);
        secondParkingLot.setRemainPosition(7);
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(new Car());
        Assertions.assertEquals(3, firstParkingLot.getRemainPosition());
        Assertions.assertEquals(6, secondParkingLot.getRemainPosition());
    }


    //===================Story 5=================

    /**
     * given: two different available position rate parking lots
     * when: super smart parking boy parking car
     * then: return: park car to the larger available position rate parking lot.
     */

    @Test
    public void should_return_decrease_position_with_larger_rate_when_parking_given_two_diff_available_rate() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(5);
        firstParkingLot.setRemainPosition(6);
        secondParkingLot.setRemainPosition(4);
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(new Car());
        Assertions.assertEquals(6, firstParkingLot.getRemainPosition());
        Assertions.assertEquals(3, secondParkingLot.getRemainPosition());
    }
}