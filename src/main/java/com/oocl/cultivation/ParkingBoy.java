package com.oocl.cultivation;

import java.util.HashMap;
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

    public Car fetchCar(Ticket ticket) {
        if (!ticketToCar.containsKey(ticket)) {
            System.out.println("Wrong ticket");
            return null;
        }
        return ticketToCar.get(ticket);
    }
}
