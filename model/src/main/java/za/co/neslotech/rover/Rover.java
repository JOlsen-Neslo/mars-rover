package za.co.neslotech.rover;

import za.co.neslotech.rover.constants.Direction;
import za.co.neslotech.rover.exceptions.ModelException;

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

    public boolean validate(Zone zone) {
        return zone.isWithinBounds(position);
    }

    public void move() throws ModelException {
        if (direction == null) {
            throw new ModelException("The direction of the rover needs to be set to move.");
        }

        switch (direction) {
            case EAST:
                position.increaseX();
                break;
            case WEST:
                position.decreaseX();
                break;
            case SOUTH:
                position.decreaseY();
                break;
            case NORTH:
                position.increaseY();
                break;
            default:
                throw new ModelException("The direction of the rover needs to be set to move.");
        }
    }

    public void rotate(int rotation) {
        int degrees = direction.getDegrees();
        degrees += rotation;

        setDirection(Direction.findDirection(degrees));
    }
}
