package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.*;

public class ZoneTest {

    private Zone zone;

    @Before
    public void setup() {
        zone = new Zone();
        zone.setCoordinate(new Coordinate());
    }

    @Test
    public void testGetCoordinate() {
        assertNotNull(zone.getCoordinate());
    }

    @Test
    public void testSetCoordinate() {
        assertNotNull(zone.getCoordinate());
        zone.setCoordinate(null);
        assertNull(zone.getCoordinate());
    }

    @Test
    public void testIsWithinBounds() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(4);
        coordinate.setY(12);
        zone.setCoordinate(coordinate);

        Coordinate position = new Coordinate();
        position.setX(4);
        position.setY(11);
        assertTrue(zone.isWithinBounds(position));

        position.setY(12);
        assertTrue(zone.isWithinBounds(position));

        position.setX(8);
        assertFalse(zone.isWithinBounds(position));

        position.setX(4);
        position.setY(88);
        assertFalse(zone.isWithinBounds(position));
    }

}
