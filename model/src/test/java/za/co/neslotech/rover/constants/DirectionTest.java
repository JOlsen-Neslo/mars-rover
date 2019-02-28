package za.co.neslotech.rover.constants;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    private Direction direction;

    @Before
    public void setup() {
        direction = Direction.WEST;
    }

    @Test
    public void testGetSymbol() {
        assertEquals("W", direction.getSymbol());
    }

    @Test
    public void testGetDegrees() {
        assertEquals(270, direction.getDegrees());
    }

    @Test
    public void testGetOptions() {
        assertEquals(2, direction.getOptions().size());
    }

    @Test
    public void testFindDirectionSymbol() {
        assertEquals(Direction.EAST, Direction.findDirection("E"));
        assertEquals(Direction.WEST, Direction.findDirection("w"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindDirectionSymbolException() {
        Direction.findDirection("f");
    }

    @Test
    public void testFindDirectionDegrees() {
        assertEquals(Direction.EAST, Direction.findDirection(90));
        assertEquals(Direction.WEST, Direction.findDirection(270));
        assertEquals(Direction.WEST, Direction.findDirection(-90));
        assertEquals(Direction.NORTH, Direction.findDirection(0));
        assertEquals(Direction.NORTH, Direction.findDirection(360));
        assertEquals(Direction.SOUTH, Direction.findDirection(180));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindDirectionDegreesException() {
        Direction.findDirection(500);
    }

    @Test
    public void testToString() {
        assertEquals("E", Direction.EAST.toString());
    }

}
