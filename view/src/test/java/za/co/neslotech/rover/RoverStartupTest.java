package za.co.neslotech.rover;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoverStartupTest {

    @Test
    public void testGetStarted() {
        RoverStartup startup = new RoverStartup();
        assertTrue(startup.getStarted());
    }

}
