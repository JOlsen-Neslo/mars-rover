package za.co.neslotech.rover;

import za.co.neslotech.rover.constants.Direction;
import za.co.neslotech.rover.exceptions.ServiceException;

public class RoverService {

    private static Zone zone;
    private static Rover rover;

    public void createZone(String coordinate) throws ServiceException {
        String[] coordinateSplit = coordinate.split(" ");
        if (coordinateSplit.length < 2) {
            throw new ServiceException("The coordinates supplied are an invalid format. "
                    + "Please use the following format: e.g. 10 12");
        }

        Zone newZone = new Zone();
        Coordinate zoneCoordinate = createCoordinate(coordinateSplit[0], coordinateSplit[1]);
        newZone.setCoordinate(zoneCoordinate);

        setZone(newZone);
    }

    public void createRover(String placement) throws ServiceException {
        String[] placementSplit = placement.split(" ");
        if (placementSplit.length < 3) {
            throw new ServiceException("The placement supplied is an invalid format. "
                    + "Please use the following format: e.g. 10 12 E");
        }

        Rover newRover = new Rover();

        Coordinate startingPoint = createCoordinate(placementSplit[0], placementSplit[1]);
        newRover.setPosition(startingPoint);

        Direction direction = Direction.findDirection(placementSplit[2]);
        newRover.setDirection(direction);

        setRover(newRover);
        validatePosition();
    }

    private void validatePosition() throws ServiceException {
        Coordinate roverPosition = rover.getPosition();
        if (!zone.isWithinBounds(roverPosition)) {
            throw new ServiceException("The rovers current position is currently out of the zone bounds. "
                    + "Zone bounds: "
                    + zone.getCoordinate().toString()
                    + ". Rover Position: " + roverPosition.toString());
        }
    }

    private Coordinate createCoordinate(String elementX, String elementY) {
        Coordinate coordinate = new Coordinate();

        int x = Integer.parseInt(elementX);
        if (x < 1) {
            throw new IllegalArgumentException("The x coordinate supplied cannot be negative or zero.");
        }
        coordinate.setX(x);

        int y = Integer.parseInt(elementY);
        if (y < 1) {
            throw new IllegalArgumentException("The y coordinate supplied cannot be negative or zero.");
        }
        coordinate.setY(y);

        return coordinate;
    }

    private void setZone(Zone newZone) {
        zone = newZone;
    }

    private void setRover(Rover newRover) {
        rover = newRover;
    }

}
