package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(LinkedList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        if (car == null) {
            return null;
        }

        int totalRemainPosition = getTotalRemainPosition();
        if (totalRemainPosition == 0) {
            return  null;
        }

        Map<Ticket, Car> ticketToCar = super.getTicketToCar();
        LinkedList<ParkingLot> parkingLots = super.getParkingLots();
        if (!ticketToCar.containsValue(car)) {
            Ticket ticket = new Ticket();
            ticketToCar.put(ticket, car);
            int position = getParkingLotWithMostAvailablePosition(parkingLots);
            parkingLots.get(position).decreasePostion();
            return ticket;
        }
        return null;
    }


    public int getParkingLotWithMostAvailablePosition(LinkedList<ParkingLot> parkingLots) {
        int position = -1;
        double mostAvailable = 0.0;
        for (int index = 0; index < parkingLots.size(); index++) {
            double availableRate = (double)parkingLots.get(index).getRemainPosition() / parkingLots.get(index).getTotalPosition();
            if (availableRate > mostAvailable) {
                mostAvailable = availableRate;
                position = index;
            }
        }
        return position;
    }
}
