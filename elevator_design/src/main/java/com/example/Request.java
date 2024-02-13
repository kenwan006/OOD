package com.example;

public class Request {
    int currentFloor;
    int desiredFloor;
    Direction direction;
    Location location;

    public Request(int currFloor, int desiredFloor, Direction direction, Location location) {
        this.currentFloor = currFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.location = location;
    }
}
