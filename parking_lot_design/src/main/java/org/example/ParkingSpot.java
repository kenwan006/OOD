package org.example;

public abstract  class ParkingSpot {
    public int id;
    public String parkingLocation;
    public float hourlyRate;

    //park the car into the parkingSpot
    public abstract void park(ParkingLot parkingLot, ParkingSpot parkingSpot);

    //exit the car off the parkingSpot
    public abstract void exit(ParkingLot parkingLot, ParkingSpot parkingSpot);

    //find an unoccupied spot
    public int findSpot(boolean[] occupiedSpot) {
        for (int i = 0; i < occupiedSpot.length; i++) {
            if (!occupiedSpot[i]) {
                occupiedSpot[i] = true;
                return i;
            }
        }
        return -1;
    }
}
