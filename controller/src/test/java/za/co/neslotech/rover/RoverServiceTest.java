package za.co.neslotech.rover;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoverServiceTest {

    @Test
    public void testGetStarted() {
        RoverService service = new RoverService();
        assertTrue(service.getStarted());
    }

}
