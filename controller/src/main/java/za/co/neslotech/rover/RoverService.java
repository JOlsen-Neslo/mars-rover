package za.co.neslotech.rover;

import za.co.neslotech.rover.exceptions.ServiceException;

public class RoverService {

    private static Zone zone;

    public void createZone(String coordinate) throws ServiceException {
        String[] coordinateSplit = coordinate.split(" ");
        if (coordinateSplit.length < 2) {
            throw new ServiceException("The coordinates supplied are an invalid format.");
        }

        Zone newZone = new Zone();
        newZone.setLength(coordinateSplit[0]);
        newZone.setBreadth(coordinateSplit[1]);

        setZone(newZone);
    }

    private static void setZone(Zone newZone) {
        zone = newZone;
    }

}
