package org.example;

public class HandicapSpot extends ParkingSpot{
    public HandicapSpot() {
        this.hourlyRate = 2;
    }

    @Override
    public void park(ParkingLot parkingLot, ParkingSpot parkingSpot) {
        //find an unoccupied handicap parking spot
        this.id = findSpot(parkingLot.occupiedHandicap);
        this.parkingLocation = "H" + id;


        parkingLot.compactSpotMap.put(parkingLocation, parkingSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot parkingSpot) {
        parkingLot.handicapSpotMap.remove(parkingSpot.parkingLocation);
        parkingLot.availableHandicapSpot++;
        parkingLot.occupiedHandicap[id] = false; //free the occupied handicap parking spot

    }
}
