package com.martianrobots;

public class MarsSurface {
    private final int topRightXCoordinate;
    private final int topRightYCoordinate;

    public MarsSurface(int topRightXCoordinate, int topRightYCoordinate) {
        validateTheInputCoordinates(topRightXCoordinate, topRightYCoordinate);
        this.topRightXCoordinate = topRightXCoordinate;
        this.topRightYCoordinate = topRightYCoordinate;
    }

    private void validateTheInputCoordinates(int topRightXPosition, int topRightYPosition) {
        if (topRightXPosition > 50 || topRightYPosition > 50) {
            throw new IllegalArgumentException("Top Right Position Coordinates cannot be greater than 50");
        }
    }

    public int getTopRightXCoordinate() {
        return topRightXCoordinate;
    }

    public int getTopRightYCoordinate() {
        return topRightYCoordinate;
    }
}
