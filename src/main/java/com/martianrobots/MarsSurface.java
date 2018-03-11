package com.martianrobots;

import com.martianrobots.model.Position;

import java.util.ArrayList;
import java.util.List;

import static com.martianrobots.model.Position.position;

public class MarsSurface {
    private Position topRight;
    private Position bottomLeft = position(0, 0);
    private List<Position> positionsToAvoid;

    public MarsSurface(int topRightXCoordinate, int topRightYCoordinate) {
        validateTheInputCoordinates(topRightXCoordinate, topRightYCoordinate);
        this.topRight = position(topRightXCoordinate, topRightYCoordinate);
        this.positionsToAvoid = new ArrayList<Position>();
    }

    private void validateTheInputCoordinates(int topRightXPosition, int topRightYPosition) {
        if (topRightXPosition > 50 || topRightYPosition > 50) {
            throw new IllegalArgumentException("Top Right Position Coordinates cannot be greater than 50");
        }
    }

    public boolean isWithinBounds(Position position) {
        return position.getXCoordinate() <= topRight.getXCoordinate()
                && position.getYCoordinate() <= topRight.getYCoordinate()
                && position.getXCoordinate() >= bottomLeft.getXCoordinate()
                && position.getYCoordinate() >= bottomLeft.getYCoordinate();
    }

    public void addPositionsToAvoid(Position position) {
        positionsToAvoid.add(position);
    }

    public boolean isPositionMarkedToBeIgnored(Position position) {
        return positionsToAvoid.contains(position);
    }
}
