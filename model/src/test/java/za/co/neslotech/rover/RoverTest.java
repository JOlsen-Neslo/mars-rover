package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;
import za.co.neslotech.rover.constants.Direction;
import za.co.neslotech.rover.exceptions.ModelException;

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

    @Test
    public void testMove() throws ModelException {
        Coordinate position = rover.getPosition();

        rover.setDirection(Direction.EAST);
        rover.move();
        assertEquals(1, position.getX());

        rover.setDirection(Direction.WEST);
        rover.move();
        assertEquals(0, position.getX());

        rover.setDirection(Direction.NORTH);
        rover.move();
        assertEquals(1, position.getY());

        rover.setDirection(Direction.SOUTH);
        rover.move();
        assertEquals(0, position.getY());
    }

    @Test(expected = ModelException.class)
    public void testMoveException() throws ModelException {
        rover.setDirection(null);
        rover.move();
    }

    @Test
    public void testRotate() {
        assertEquals(Direction.EAST, rover.getDirection());

        rover.rotate(90);
        assertEquals(Direction.SOUTH, rover.getDirection());

        rover.rotate(90);
        assertEquals(Direction.WEST, rover.getDirection());

        rover.rotate(90);
        assertEquals(Direction.NORTH, rover.getDirection());

        rover.rotate(90);
        assertEquals(Direction.EAST, rover.getDirection());

        rover.rotate(-90);
        assertEquals(Direction.NORTH, rover.getDirection());

        rover.rotate(-90);
        assertEquals(Direction.WEST, rover.getDirection());

        rover.rotate(-90);
        assertEquals(Direction.SOUTH, rover.getDirection());

        rover.rotate(-90);
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void testValidate() {
        Zone zone = new Zone();
        Coordinate coordinate = new Coordinate();

        coordinate.setX(1);
        coordinate.setY(2);
        zone.setCoordinate(coordinate);

        assertTrue(rover.validate(zone));

        Coordinate position = rover.getPosition();
        position.setY(3);

        assertFalse(rover.validate(zone));
    }

}
