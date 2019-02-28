package za.co.neslotech.rover.constants;

public enum Direction {

    NORTH("N", 0),
    EAST("E", 90),
    WEST("W", 270),
    SOUTH("S", 180);

    private String symbol;
    private int degrees;

    Direction(final String symbol, final int degrees) {
        this.symbol = symbol;
        this.degrees = degrees;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getDegrees() {
        return degrees;
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
            if (value.degrees == degrees) {
                return value;
            }
        }

        throw new IllegalArgumentException("A direction could not be found for the supplied degrees: " + degrees
                + ". Possible values: [0, 90, 180, 270]");
    }

}
