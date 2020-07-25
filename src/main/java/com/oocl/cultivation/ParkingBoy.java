package com.oocl.cultivation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParkingBoy {
    private LinkedList<ParkingLot> parkingLots;
    private int remainPosition;
    private Map<Car, Ticket> carToTicket;
    private Map<Ticket, Car> ticketToCar;

    public ParkingBoy() {
        remainPosition = 10;
        this.carToTicket = new HashMap<>();
        this.ticketToCar = new HashMap<>();
    }

    public ParkingBoy(LinkedList<ParkingLot> parkingLots) {
        this();
        this.parkingLots = parkingLots;
    }

    public void setRemainPosition(int remainPosition) {
        this.remainPosition = remainPosition;
    }

    public int getRemainPosition() {
        return remainPosition;
    }

    //this method can be refactor into park(LinkedList<Car> car), but will affect lots of test case.
    public Ticket park(Car car) {
        if (car == null) {
            return null;
        }
        if (getRemainPosition() == 0) {
            return null;
        }
        if (!carToTicket.containsKey(car)) {
            Ticket ticket = new Ticket();
            carToTicket.put(car, ticket);
            ticketToCar.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public LinkedList<Ticket> park(LinkedList<Car> cars) {
        LinkedList<Ticket> returnTickets = new LinkedList<>();
        for (Car car : cars) {
            Ticket ticket = new Ticket();
            carToTicket.put(car, ticket);
            ticketToCar.put(ticket, car);
            returnTickets.add(ticket);
        }
        return returnTickets;
    }



    public Car fetchCar(Ticket ticket) {
        if (ticket == null || !ticketToCar.containsKey(ticket)) {
            return null;
        }
        Car car = ticketToCar.get(ticket);
        ticketToCar.remove(ticket);
        carToTicket.remove(car);
        return car;
    }


    public String response(Ticket ticket) {
        if (ticket == null && getRemainPosition() == 0) {
            return "Not enough position.";
        }

        if (ticket == null) {
            return "Please provide your parking ticket.";
        }
        if (!ticketToCar.containsKey(ticket)) {
            return "Unrecognized parking ticket";
        }
        return null;
    }

//    public String fetch(Ticket ticket) {
//        String unrecognizedMessage = "Unrecognized parking ticket";
//        if (!isCorrectTicket(ticket)) {
//            return unrecognizedMessage;
//        }
//        return null;
//    }


//    public boolean isCorrectTicket(Ticket ticket) {
//        if (ticket == null) {
//            return false;
//        }
//        if (!ticketToCar.containsKey(ticket)) {
//            return false;
//        }
//        return true;
//    }
}
