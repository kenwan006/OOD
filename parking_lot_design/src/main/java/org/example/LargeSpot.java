package org.example;

public class LargeSpot extends ParkingSpot{
    public LargeSpot() {
        this.hourlyRate = 30;
    }
    @Override
    public void park(ParkingLot parkingLot, ParkingSpot parkingSpot) {
        this.id = findSpot(parkingLot.occupiedLarge);
        this.parkingLocation = "L" + id;

        parkingLot.availableLargeSpot--;
        parkingLot.largeSpotMap.put(parkingLocation, parkingSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot parkingSpot) {
        parkingLot.largeSpotMap.remove(parkingLocation);
        parkingLot.availableLargeSpot++;
        parkingLot.occupiedLarge[id] = false; //free the occupied large parking spot
    }
}
