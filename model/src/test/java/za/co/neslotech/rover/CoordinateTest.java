package za.co.neslotech.rover;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    private Coordinate coordinate;

    @Before
    public void setup() {
        coordinate = new Coordinate();
        coordinate.setX(2);
        coordinate.setY(5);
    }

    @Test
    public void testGetX() {
        assertEquals(2, coordinate.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(5, coordinate.getY());
    }

    @Test
    public void testSetX() {
        assertEquals(2, coordinate.getX());
        coordinate.setX(5);
        assertEquals(5, coordinate.getX());
    }

    @Test
    public void testSetY() {
        assertEquals(5, coordinate.getY());
        coordinate.setY(2);
        assertEquals(2, coordinate.getY());
    }

    @Test
    public void testToString() {
        assertEquals("[2, 5]", coordinate.toString());
    }

}
