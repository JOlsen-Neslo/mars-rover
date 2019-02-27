package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;
import za.co.neslotech.rover.exceptions.ServiceException;

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
        } catch (ServiceException e) {
            fail("The method call was not meant to throw an exception: " + e.getMessage());
        }
    }

    @Test(expected = ServiceException.class)
    public void testCreateZoneException() throws ServiceException {
        roverService.createZone("8");
    }

}
