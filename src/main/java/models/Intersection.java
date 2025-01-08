package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Direction;
import enums.TrafficCycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Intersection {
    // traffic lights list
    private List<TrafficLight> trafficLights = new ArrayList<>();

    // current light cycle (default - green for north and south)
    private TrafficCycle currentGreen = TrafficCycle.EAST_WEST;

    // queues for each direction
    private Queue<Vehicle> northQueue = new LinkedList<>();
    private Queue<Vehicle> southQueue = new LinkedList<>();
    private Queue<Vehicle> eastQueue = new LinkedList<>();
    private Queue<Vehicle> westQueue = new LinkedList<>();

    // adding a traffic light
    public void addTrafficLight(TrafficLight trafficLight) {
        trafficLights.add(trafficLight);
    }

    // updating traffic light with current cycle
    public void updateTrafficLights() {
        for (TrafficLight light : trafficLights) {
            if (currentGreen == TrafficCycle.NORTH_SOUTH &&
                (light.getDirection() == Direction.NORTH || light.getDirection() == Direction.SOUTH)) {
                light.nextColor();
            } else if (currentGreen == TrafficCycle.EAST_WEST &&
            (light.getDirection() == Direction.EAST || light.getDirection() == Direction.NORTH)) {
                light.nextColor();
            } else {
                light.nextColor();
            }
        }
    }

    // adding a vehicle to a specific queue
    public void addVehicle (Vehicle vehicle) {
        switch (vehicle.getStartRoad()) {
            case NORTH -> northQueue.add(vehicle);
            case SOUTH -> southQueue.add(vehicle);
            case EAST -> eastQueue.add(vehicle);
            case WEST -> westQueue.add(vehicle);
        }
    }

    // making simulation step
    public List<String> step() {
        List<String> leftVehicles = new ArrayList<>();

        System.out.println("Current cycle: " + currentGreen);

        // adding left vehicle to list
        switch (currentGreen) {
            case NORTH_SOUTH -> {
                if (!northQueue.isEmpty()) leftVehicles.add(northQueue.poll().getId());
                if (!southQueue.isEmpty()) leftVehicles.add(southQueue.poll().getId());
                currentGreen = TrafficCycle.EAST_WEST;
            }
            case EAST_WEST -> {
                if (!eastQueue.isEmpty()) leftVehicles.add(eastQueue.poll().getId());
                if (!westQueue.isEmpty()) leftVehicles.add(westQueue.poll().getId());
                currentGreen = TrafficCycle.NORTH_SOUTH;
            }
        }
        updateTrafficLights();

        return leftVehicles;
    }

    // debugging intersection state
    public void printQueues(){
        System.out.println("North queue: " + northQueue);
        System.out.println("South queue: " + southQueue);
        System.out.println("East queue: " + eastQueue);
        System.out.println("West queue: " + westQueue);
    }

}
