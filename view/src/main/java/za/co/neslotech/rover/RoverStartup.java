package za.co.neslotech.rover;

import za.co.neslotech.rover.exceptions.ServiceException;

import java.util.Scanner;

public class RoverStartup {

    private static RoverService roverService = new RoverService();

    public static void main(String[] args) {
        retrieveCoordinate();
    }

    private static void retrieveCoordinate() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Please enter the zone cartesian coordinate:");
        String coordinate = scanner.nextLine();
        if (coordinate == null || coordinate.trim().isEmpty()) {
            System.err.println("The value supplied is invalid. Please use the following format: e.g. 10 12");
            System.exit(1);
        }

        try {
            roverService.createZone(coordinate);
        } catch (ServiceException error) {
            System.err.println(error.getMessage());
            System.err.println("The value supplied is invalid. Please use the following format: e.g. 10 12");
            System.exit(1);
        }
    }

}
