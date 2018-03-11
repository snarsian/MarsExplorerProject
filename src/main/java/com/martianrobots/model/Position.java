package com.martianrobots.model;

public class Position {

    private final int xCoordinate;
    private final int yCoordinate;

    private Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Position position(int xCoordinate, int yCoordinate){
        return new Position(xCoordinate,yCoordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (xCoordinate != position.xCoordinate) return false;
        return yCoordinate == position.yCoordinate;
    }

    @Override
    public int hashCode() {
        int result = xCoordinate;
        result = 31 * result + yCoordinate;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}