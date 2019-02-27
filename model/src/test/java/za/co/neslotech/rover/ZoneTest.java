package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ZoneTest {

    private Zone zone;

    @Before
    public void setup() {
        zone = new Zone();
        zone.setLength("length");
        zone.setBreadth("breadth");
    }

    @Test
    public void testGetLength() {
        assertEquals("length", zone.getLength());
    }

    @Test
    public void testGetBreadth() {
        assertEquals("breadth", zone.getBreadth());
    }

    @Test
    public void testSetLength() {
        assertEquals("length", zone.getLength());
        zone.setLength("change");
        assertEquals("change", zone.getLength());
    }

    @Test
    public void testSetBreadth() {
        assertEquals("breadth", zone.getBreadth());
        zone.setBreadth("change");
        assertEquals("change", zone.getBreadth());
    }

}
