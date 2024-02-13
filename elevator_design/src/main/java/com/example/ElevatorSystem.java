package com.example;

import java.util.ArrayList;
import java.util.List;

// Represents the elevator control system
class ElevatorSystem {
    List<Elevator> elevators;

    public ElevatorSystem(int numElevators, int initialFloor) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator("Elevator-" + i, initialFloor));
        }
    }

    public void sendUpRequest(int elevatorIndex, Request request) {
        elevators.get(elevatorIndex).sendUpRequest(request);
    }

    public void sendDownRequest(int elevatorIndex, Request request) {
        elevators.get(elevatorIndex).sendDownRequest(request);
    }

    public void run() {
        for (Elevator elevator : elevators) {
            elevator.run();
        }
    }

    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(2, 0);

        // Example usage: Send up request to elevator 0 from floor 3
        elevatorSystem.sendUpRequest(0, new Request(3, 5, Direction.UP, Location.OUTSIDE_ELEVATOR));

        // Example usage: Send down request to elevator 1 from floor 6
        elevatorSystem.sendDownRequest(1, new Request(6, 2, Direction.DOWN, Location.OUTSIDE_ELEVATOR));

        // Start elevator system
        elevatorSystem.run();
    }

}

