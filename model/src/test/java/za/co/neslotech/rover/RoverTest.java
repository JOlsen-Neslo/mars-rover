package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;
import za.co.neslotech.rover.constants.Direction;

import static org.junit.Assert.*;

public class RoverTest {

    private Rover rover;

    @Before
    public void setup() {
        rover = new Rover();
        rover.setPosition(new Coordinate());
        rover.setDirection(Direction.EAST);
    }

    @Test
    public void testGetPosition() {
        assertNotNull(rover.getPosition());
    }

    @Test
    public void testGetDirection() {
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void testSetPosition() {
        assertNotNull(rover.getPosition());
        rover.setPosition(null);
        assertNull(rover.getPosition());
    }

    @Test
    public void testSetDirection() {
        assertEquals(Direction.EAST, rover.getDirection());
        rover.setDirection(Direction.WEST);
        assertEquals(Direction.WEST, rover.getDirection());
    }

}
