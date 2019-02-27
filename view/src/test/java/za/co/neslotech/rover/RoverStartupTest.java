package za.co.neslotech.rover;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RoverStartupTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testRetrieveCoordinate() {
        String input = "10 12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RoverStartup.main(null);
    }

    @Test
    public void testRetrieveCoordinateEmpty() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        exit.expectSystemExitWithStatus(1);
        RoverStartup.main(null);

        System.setIn(null);

        exit.expectSystemExitWithStatus(1);
        RoverStartup.main(null);
    }

    @Test
    public void testRetrieveCoordinateIncorrectInput() {
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        exit.expectSystemExitWithStatus(1);
        RoverStartup.main(null);
    }

}
