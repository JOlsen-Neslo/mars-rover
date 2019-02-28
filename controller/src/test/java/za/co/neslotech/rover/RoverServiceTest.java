package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;
import za.co.neslotech.rover.exceptions.ServiceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RoverServiceTest {

    private RoverService roverService;

    @Before
    public void setup() {
        roverService = new RoverService();
    }

    @Test
    public void testCreateZone() {
        try {
            roverService.createZone("8 8");
        } catch (ServiceException | IllegalArgumentException e) {
            fail("The method call was not meant to throw an exception: " + e.getMessage());
        }
    }

    @Test(expected = ServiceException.class)
    public void testCreateZoneServiceException() throws ServiceException {
        roverService.createZone("8");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZoneIllegalArgumentExceptionX() throws ServiceException {
        roverService.createZone("-8 8");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZoneIllegalArgumentExceptionY() throws ServiceException {
        roverService.createZone("8 -8");
    }

    @Test
    public void testCreateRover() {
        try {
            roverService.createZone("8 8");
            roverService.createRover("8 8 E");
        } catch (ServiceException | IllegalArgumentException e) {
            fail("The method call was not meant to throw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testCreateRoverInvalidPosition() {
        try {
            roverService.createZone("8 8");
            roverService.createRover("9 8 E");
            fail("The method call was meant to throw an exception.");
        } catch (ServiceException | IllegalArgumentException e) {
            assertEquals("The rovers current position is currently out of the zone bounds. " +
                    "Zone bounds: [8, 8]. Rover Position: [9, 8]", e.getMessage());
        }
    }

    @Test(expected = ServiceException.class)
    public void testCreateRoverServiceException() throws ServiceException {
        roverService.createRover("8");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateRoverIllegalArgumentException() throws ServiceException {
        roverService.createRover("8 8 f");
    }

}
