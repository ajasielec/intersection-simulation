package models;

import enums.Direction;

public class Vehicle {
    private String id;
    private Direction startRoad;
    private Direction endRoad;

    // constructor
    public Vehicle(String id, Direction startRoad, Direction endRoad) {
        this.id = id;
        this.startRoad = startRoad;
        this.endRoad = endRoad;
    }

    public Vehicle() {}

    // getters
    public String getId() {return id;}
    public Direction getStartRoad() {return startRoad;}
    public Direction getEndRoad() {return endRoad;}

    @Override
    public String toString() {
        return "Vehicle {id=" + id + ", startRoad=" + startRoad + ", endRoad=" + endRoad + "}";
    }
}
