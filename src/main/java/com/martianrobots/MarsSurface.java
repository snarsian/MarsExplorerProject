package com.martianrobots;

import com.martianrobots.model.Position;

import static com.martianrobots.model.Position.position;

public class MarsSurface {
    private Position topRight;
    private Position bottomLeft = position(0, 0);

    public MarsSurface(int topRightXCoordinate, int topRightYCoordinate) {
        validateTheInputCoordinates(topRightXCoordinate, topRightYCoordinate);
        this.topRight = position(topRightXCoordinate, topRightYCoordinate);
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
}
