package org.example;

public class CompactSpot extends ParkingSpot{
    public CompactSpot(){
        this.hourlyRate = 10;
    }

    @Override
    public void park(ParkingLot parkingLot, ParkingSpot parkingSpot) {
        int id = findSpot(parkingLot.occupiedCompact);
        this.parkingLocation = "C" + id;

        parkingLot.compactSpotMap.put(parkingLocation, parkingSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot parkingSpot) {
        parkingLot.compactSpotMap.remove(parkingLocation);
        parkingLot.availableCompactSpot++;
        parkingLot.occupiedLarge[id] = false; //free the compact parking spot
    }
}
