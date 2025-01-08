package simulation;

import java.util.List;

public class StepStatus {
    private List<String> leftVehicles;

    // constructor
    public StepStatus(List<String> leftVehicles) {
        this.leftVehicles = leftVehicles;
    }

    // getters and setters
    public List<String> getLeftVehicles() {return leftVehicles;}
    public void setLeftVehicles(List<String> leftVehicles) {this.leftVehicles = leftVehicles;}
}
