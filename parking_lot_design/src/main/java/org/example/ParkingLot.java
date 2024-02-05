package org.example;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<String, ParkingSpot> largeSpotMap = new HashMap<>();
    Map<String, ParkingSpot> compactSpotMap = new HashMap<>();
    Map<String, ParkingSpot> handicapSpotMap = new HashMap<>();
    Map<String, Ticket> ticketMap = new HashMap<>();

    int availableLargeSpot = 100;
    int availableCompactSpot = 100;
    int availableHandicapSpot = 100;

    boolean[] occupiedLarge = new boolean[100];
    boolean[] occupiedCompact = new boolean[100];
    boolean[] occupiedHandicap = new boolean[100];

    public Ticket park(String vehicleType)  throws  Exception{
        //check if there is parking spot available
        if (checkFull(vehicleType)) {
            throw new Exception("Parking is Full");
        }

        //update parking spot by the vehicleType
        ParkingSpot parkingSpot = getParkingSpot(vehicleType);
        parkingSpot.park(this, parkingSpot);

        //handle ticket creation
        Ticket ticket = new Ticket();
        ticket.setEnter(Timestamp.from(Instant.now().minus(3, ChronoUnit.HOURS)));
        ticket.setParkingLocation(parkingSpot.parkingLocation);
        ticket.setHourlyRate(parkingSpot.hourlyRate);
        ticket.setParkingSpot(parkingSpot);
        ticketMap.put(parkingSpot.parkingLocation, ticket);

        System.out.println("Welcome Enter parking Lot, you enter at time: " + ticket.getEnter());
        System.out.println("Your vehicle is: " + vehicleType);
        return ticket;
    }

    public Ticket exit(String parkingLocation) {
        Ticket ticket = ticketMap.get(parkingLocation);

        //update the parking spot
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.exit(this, parkingSpot);

        //calculate the parking fee
        ticket.calculate();
        System.out.println("You have parked from " + ticket.getEnter() + "to " + ticket.getExit());
        System.out.println("Total fee is: " + ticket.getChargeAmount() + " | hourlyRate is " + ticket.getHourlyRate());
        return ticket;
    }

    private boolean checkFull(String vehicleType) {
        if (vehicleType.equals("large")) return availableLargeSpot <= 0;
        else if (vehicleType.equals("compact")) return availableCompactSpot <= 0;
        else if (vehicleType.equals("handicap")) return availableHandicapSpot <= 0;
        return true;
    }

    private ParkingSpot getParkingSpot (String vehicleType) {
        if (vehicleType.equals("large")) return new LargeSpot();
        else if (vehicleType.equals("compact")) return new CompactSpot();
        else if (vehicleType.equals("handicap")) return new HandicapSpot();
        else return null;
    }
}
