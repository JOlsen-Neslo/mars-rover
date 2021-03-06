package za.co.neslotech.rover;

import za.co.neslotech.rover.exceptions.ServiceException;

import java.util.Scanner;

public class RoverStartup {

    private static RoverService roverService = new RoverService();
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in, "UTF-8");

        retrieveCoordinate();
        placeRover();
        displayRoverLocation();
        readCommands();
        displayRoverLocation();
    }

    private static void displayRoverLocation() {
        String roverLocation = roverService.locateRover();
        System.out.println("The rover is currently located at: " + roverLocation);
    }

    private static void retrieveCoordinate() {
        System.out.println("Please enter the zone boundary cartesian coordinate: (e.g. 10 12)");
        String coordinate = scanner.nextLine();
        if (coordinate == null || coordinate.trim().isEmpty()) {
            System.err.println("The value supplied is invalid. Please use the following format: e.g. 10 12");
            System.exit(1);
        }

        try {
            roverService.createZone(coordinate.trim());
        } catch (ServiceException | IllegalArgumentException error) {
            System.err.println(error.getMessage());
            System.exit(1);
        }
    }

    private static void placeRover() {
        System.out.println("Please enter the starting cartesian coordinate of the rover, "
                + "followed by the direction it is facing: (e.g. 10 12 E)");
        String placement = scanner.nextLine();
        if (placement == null || placement.trim().isEmpty()) {
            System.err.println("The value supplied is invalid. Please use the following format: e.g. 10 12 E");
            System.exit(1);
        }

        try {
            roverService.createRover(placement.trim());
        } catch (ServiceException | IllegalArgumentException error) {
            System.err.println(error.getMessage());
            System.exit(1);
        }
    }

    private static void readCommands() {
        System.out.println("Please enter the list of commands for the rover: (e.g MLMRM)");
        String commands = scanner.nextLine();
        if (commands == null || commands.trim().isEmpty()) {
            System.err.println("The value supplied is invalid. Please use the following format: e.g. MLMRM");
            System.exit(1);
        }

        try {
            roverService.processCommands(commands.trim());
        } catch (ServiceException | IllegalArgumentException error) {
            System.err.println(error.getMessage());
            System.exit(1);
        }
    }

}
