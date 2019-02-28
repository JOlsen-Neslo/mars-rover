package za.co.neslotech.rover;

public class Zone {

    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isWithinBounds(Coordinate position) {
        if (position.getX() > coordinate.getX()) {
            return false;
        }

        return position.getY() <= coordinate.getY();
    }
}
