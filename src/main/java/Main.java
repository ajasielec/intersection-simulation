import enums.Direction;
import models.Intersection;
import models.TrafficLight;
import models.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.JsonUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Intersection intersection = new Intersection();

        // creating lights
        TrafficLight northLight = new TrafficLight(Direction.NORTH, 30, 5, 60);
        TrafficLight southLight = new TrafficLight(Direction.SOUTH, 30, 5, 60);
        TrafficLight eastLight = new TrafficLight(Direction.EAST, 30, 5, 60);
        TrafficLight westLight = new TrafficLight(Direction.WEST, 30, 5, 60);

        // adding lights to intersection
        intersection.addTrafficLight(northLight);
        intersection.addTrafficLight(southLight);
        intersection.addTrafficLight(eastLight);
        intersection.addTrafficLight(westLight);

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
        System.out.println("Step 2: " + intersection.step());
        System.out.println("Step 3: " + intersection.step());
        System.out.println("Step 4: " + intersection.step());

        // creating light

        System.out.println(northLight);

        northLight.nextColor();
        System.out.println(northLight);

        // JSON serialization
        try {
            String json = JsonUtils.serialize(vehicle1);
            System.out.println("Serialized JSON: " + json);

            Vehicle vehicle = JsonUtils.deserialize(json, Vehicle.class);
            System.out.println("Deserialized Vehicle: " + vehicle);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}