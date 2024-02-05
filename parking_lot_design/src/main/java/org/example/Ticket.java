package org.example;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class Ticket {
    private String parkingLocation;
    private Timestamp enter;
    private Timestamp exit;
    private float hourlyRate;
    private float chargeAmount;
    private ParkingSpot parkingSpot;

    public void calculate(){
        this.exit = Timestamp.from(Instant.now());
        Duration duration = Duration.between(enter.toLocalDateTime(), this.exit.toLocalDateTime());
        this.chargeAmount = duration.toHours() * hourlyRate;
    }

    public String getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public Timestamp getEnter() {
        return enter;
    }

    public void setEnter(Timestamp enter) {
        this.enter = enter;
    }

    public Timestamp getExit() {
        return exit;
    }

    public void setExit(Timestamp exit) {
        this.exit = exit;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public float getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(float chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
