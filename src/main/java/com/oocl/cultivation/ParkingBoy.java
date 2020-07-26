package com.oocl.cultivation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParkingBoy {
    private LinkedList<ParkingLot> parkingLots;
    private Map<Ticket, Car> ticketToCar;

    public ParkingBoy() {
        this.ticketToCar = new HashMap<>();
        this.parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
    }

    public ParkingBoy(LinkedList<ParkingLot> parkingLots) {
        this();
        this.parkingLots = parkingLots;
    }


    //this method can be refactor into park(LinkedList<Car> car), but will affect lots of test case.
    public Ticket park(Car car) {
        if (car == null) {
            return null;
        }

        int totalRemainPosition = getTotalRemainPosition();
        if (totalRemainPosition == 0) {
            return  null;
        }

//        if (!carToTicket.containsKey(car)) {
        if (!ticketToCar.containsValue(car)) { //containsValue效率貌似有点低
            Ticket ticket = new Ticket();
            ticketToCar.put(ticket, car);
            if (parkingLots != null) {
                for (int index = 0; index < parkingLots.size(); index++) {
                    if (parkingLots.get(index).getRemainPosition() >= 1) {
                        parkingLots.get(index).decreasePostion();
                        break;
                    }
                }
            }
            return ticket;
        }
        return null;
    }

    public int getTotalRemainPosition() {
        int totalRemainPosition = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getRemainPosition() > 0) {
                totalRemainPosition += parkingLot.getRemainPosition();
            }
        }
        return totalRemainPosition;
    }

    public LinkedList<Ticket> park(LinkedList<Car> cars) {
        LinkedList<Ticket> returnTickets = new LinkedList<>();
        for (Car car : cars) {
            Ticket ticket = new Ticket();
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
        return car;
    }


    public String response(Ticket ticket) {
        if (ticket == null && getTotalRemainPosition() == 0) {
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

}
