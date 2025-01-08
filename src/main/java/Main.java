import enums.Direction;
import models.Intersection;
import models.TrafficLight;
import models.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import simulation.Command;
import simulation.CommandList;
import simulation.SimulationResult;
import simulation.StepStatus;
import utils.JsonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // creating intersections


//        // creating lights
//        TrafficLight northLight = new TrafficLight(Direction.NORTH, 30, 5, 60);
//        TrafficLight southLight = new TrafficLight(Direction.SOUTH, 30, 5, 60);
//        TrafficLight eastLight = new TrafficLight(Direction.EAST, 30, 5, 60);
//        TrafficLight westLight = new TrafficLight(Direction.WEST, 30, 5, 60);
//
//        // adding lights to intersection
//        intersection.addTrafficLight(northLight);
//        intersection.addTrafficLight(southLight);
//        intersection.addTrafficLight(eastLight);
//        intersection.addTrafficLight(westLight);

//        // creating vehicles
//        Vehicle vehicle1 = new Vehicle("1", Direction.WEST, Direction.EAST);
//        Vehicle vehicle2 = new Vehicle("2", Direction.WEST, Direction.EAST);
//        Vehicle vehicle3 = new Vehicle("3", Direction.EAST, Direction.WEST);
//        Vehicle vehicle4 = new Vehicle("4", Direction.NORTH, Direction.SOUTH);
//
//        // adding vehicles to intersection
//        intersection.addVehicle(vehicle1);
//        intersection.addVehicle(vehicle2);
//        intersection.addVehicle(vehicle3);
//        intersection.addVehicle(vehicle4);
//
//        intersection.printQueues();
//
//        // step simulation
//        System.out.println("Step 1: " + intersection.step());
//        System.out.println("Step 2: " + intersection.step());
//        System.out.println("Step 3: " + intersection.step());
//        System.out.println("Step 4: " + intersection.step());
//
//
//        System.out.println(northLight);
//
//        northLight.nextColor();
//        System.out.println(northLight);

        try {
            // JSON with commands file path
            String filePath = "src/main/resources/commands.json";

            // creating intersection and simulation result
            Intersection intersection = new Intersection();
            SimulationResult simulationResult = new SimulationResult();

            // reading commands from JSON file and getting results
            CommandList commandList = JsonUtils.deserializeCommands(filePath);
            System.out.println("Deserialized commands: " + commandList.getCommands());

            // executing commands
            for (Command command : commandList.getCommands()) {
                switch (command.getType()) {
                    case "addVehicle":
                        Direction startDirection = Direction.valueOf(command.getStartRoad().toUpperCase());
                        Direction endDirection = Direction.valueOf(command.getEndRoad().toUpperCase());
                        Vehicle vehicle = new Vehicle(command.getVehicleId(), startDirection, endDirection);
                        intersection.addVehicle(vehicle);
                        break;

                    case "step":
                        List<String> leftVehicles = intersection.step();
                        simulationResult.addStepStatus(new StepStatus(leftVehicles));
                        break;

                    default:
                        System.out.println("Unknown command type: " + command.getType());
                        break;
                }
            }

            // serializing results to JSON
            String outputPath = "src/main/resources/simulationResult.json";
            JsonUtils.serializeResult(simulationResult, outputPath);

            System.out.println("Simulation results saved to: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}