package za.co.neslotech.rover;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ZoneTest {

    @Test
    public void testGetStarted() {
        Zone zone = new Zone();
        assertTrue(zone.getStarted());
    }

}
