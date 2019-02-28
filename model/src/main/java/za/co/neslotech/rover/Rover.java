package za.co.neslotech.rover;

import za.co.neslotech.rover.constants.Direction;

public class Rover {

    private Coordinate position;
    private Direction direction;

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
