import enums.Direction;
import models.Intersection;
import models.TrafficLight;
import models.Vehicle;

public class Main {
    public static void main(String[] args) {

        Intersection intersection = new Intersection();

        // creating vehicles
        Vehicle vehicle1 = new Vehicle("1", Direction.WEST, Direction.EAST);
        Vehicle vehicle2 = new Vehicle("2", Direction.WEST, Direction.EAST);
        Vehicle vehicle3 = new Vehicle("3", Direction.EAST, Direction.WEST);
        Vehicle vehicle4 = new Vehicle("4", Direction.NORTH, Direction.SOUTH);

        // adding vehicles to intersection
        intersection.addVehicle(vehicle1);
        intersection.addVehicle(vehicle2);
        intersection.addVehicle(vehicle3);
        intersection.addVehicle(vehicle4);

        intersection.printQueues();

        // step simulation
        System.out.println("Step 1: " + intersection.step());

        // creating light
        TrafficLight northLight = new TrafficLight(Direction.NORTH, 30, 5, 60);

        System.out.println(northLight);

        northLight.nextColor();
        System.out.println(northLight);



    }
}