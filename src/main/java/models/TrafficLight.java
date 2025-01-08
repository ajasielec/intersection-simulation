package models;

import enums.Direction;
import enums.LightColor;

public class TrafficLight {
    private LightColor currentColor;       // "red", "green", "yellow"
    private int greenDuration;
    private int redDuration;
    private int yellowDuration;
    private Direction direction;

    // constructor
    public TrafficLight(Direction direction, int greenDuration, int redDuration, int yellowDuration) {
        this.direction = direction;
        this.greenDuration = greenDuration;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.currentColor = LightColor.RED;
    }

    // getters
    public LightColor getCurrentColor() {return currentColor;}
    public Direction getDirection() {return direction;}


    public void nextColor() {
        // changing color
        switch (currentColor) {
            case RED:
                currentColor = LightColor.GREEN;
                break;
            case GREEN:
                currentColor = LightColor.YELLOW;
                break;
            case YELLOW:
                currentColor = LightColor.RED;
                break;
        }
    }

    public int getCurrentColorDuration(){
        switch (currentColor) {
            case GREEN:
                return greenDuration;
            case YELLOW:
                return yellowDuration;
            case RED:
                return redDuration;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "direction='" + direction + '\'' +
                ", currentColor=" + currentColor + '}';
    }

}
