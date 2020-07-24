package com.oocl.cultivation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParkingBoy {
    private Map<Car, Ticket> carToTicket;
    private Map<Ticket, Car> ticketToCar;

    public ParkingBoy() {
        this.carToTicket = new HashMap<>();
        this.ticketToCar = new HashMap<>();
    }


    public Ticket park(Car car) {
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
        if (!ticketToCar.containsKey(ticket)) {
            System.out.println("Wrong ticket");
            return null;
        }
        return ticketToCar.get(ticket);
    }
}
