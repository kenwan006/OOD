package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator {
    String name;
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(String name, int currentFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.direction = Direction.IDLE;
        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);
        downQueue = new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);
    }

    public void sendUpRequest(Request upRequest) {
        // If the request is sent from outside the elevator,
        // we need to stop at the current floor of the requester
        //to pick him up, and go to the desired floor
        if (upRequest.location == Location.OUTSIDE_ELEVATOR) {
            // Go pick up  the requester who is outside the elevator
            // that's why we set the desired floor as the current floor of the requester
            upQueue.offer(new Request(upRequest.currentFloor, upRequest.currentFloor, Direction.UP, Location.OUTSIDE_ELEVATOR ));

            System.out.println(this.name + " :append up request going to floor " + upRequest.currentFloor + ".");
        }

        // Go to the desired floor
        upQueue.offer(upRequest);
        System.out.println(this.name + " :append down request going to floor " + upRequest.desiredFloor + ".");
    }

    public void sendDownRequest(Request downRequest) {
        // Similar to the sendUpRequest logic
        if (downRequest.location == Location.OUTSIDE_ELEVATOR) {
            downQueue.offer(new Request(downRequest.currentFloor, downRequest.currentFloor, Direction.DOWN, Location.OUTSIDE_ELEVATOR));

            System.out.println(this.name + " :append down request going to floor " + downRequest.currentFloor + ".");
        }

        // Go to the desired floor
        downQueue.offer(downRequest);

        System.out.println(this.name + " :append down request going to floor " + downRequest.desiredFloor + ".");
    }

    //process the request in the queue continuously
    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }
        System.out.println(this.name + " finished all requests.");
        this.direction = Direction.IDLE;
    }

    private void processRequests() {
        //if the elevator is going up or idle, we let the upRequest be processed first
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else { //otherwise, let the downRequest be processed first
            processDownRequest();
            processUpRequest();
        }
    }

    private void processUpRequest(){
        while (!upQueue.isEmpty()) {
            Request upRequest = upQueue.poll();
            // Communicate with hardware
            this.currentFloor = upRequest.desiredFloor;
            System.out.println(this.name + " processing up requests... Elevator stop at floor " + this.currentFloor);
        }
        if (!downQueue.isEmpty()) { //change the elevator direction after all the upRequests are processed
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }
    private void processDownRequest(){
        while (!downQueue.isEmpty()) {
            Request downRequest = downQueue.poll();
            // Communicate with hardware
            this.currentFloor = downRequest.desiredFloor;
            System.out.println(this.name + " processing down requests... Elevator stop at floor " + this.currentFloor + ".");
        }
        if (!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }

}
