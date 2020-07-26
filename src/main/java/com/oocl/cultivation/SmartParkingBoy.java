package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.Map;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(LinkedList<ParkingLot> parkingLots) {
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
            int position = getParkingLotWithMostEmptyPosition(parkingLots);
            parkingLots.get(position).decreasePostion();
            return ticket;
        }
        return null;
    }

    public int getParkingLotWithMostEmptyPosition(LinkedList<ParkingLot> parkingLots) {
        int position = -1;
        int maxEmptyPosition = 0;
        for (int index = 0; index < parkingLots.size(); index++) {
            if (parkingLots.get(index).getRemainPosition() > maxEmptyPosition) {
                maxEmptyPosition = parkingLots.get(index).getRemainPosition();
                position = index;
            }
        }
        return position;
    }

}
