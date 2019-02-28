package za.co.neslotech.rover.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Direction {

    NORTH("N", 0, Arrays.asList(0, 360)),
    EAST("E", 90, Collections.singletonList(90)),
    WEST("W", 270, Arrays.asList(-90, 270)),
    SOUTH("S", 180, Collections.singletonList(180));

    private String symbol;
    private int degrees;
    private List<Integer> options;

    Direction(final String symbol, final int degrees, final List<Integer> options) {
        this.symbol = symbol;
        this.degrees = degrees;
        this.options = options;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getDegrees() {
        return degrees;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public static Direction findDirection(String symbol) {
        for (Direction value : Direction.values()) {
            if (value.symbol.equalsIgnoreCase(symbol)) {
                return value;
            }
        }

        throw new IllegalArgumentException("A direction could not be found for the supplied symbol: " + symbol
                + ". Possible values: [N, E, S, W]");
    }

    public static Direction findDirection(int degrees) {
        for (Direction value : Direction.values()) {
            if (value.options.contains(degrees)) {
                return value;
            }
        }

        throw new IllegalArgumentException("A direction could not be found for the supplied degrees: " + degrees
                + ". Possible values: [-90, 0, 90, 180, 270, 360]");
    }

}
