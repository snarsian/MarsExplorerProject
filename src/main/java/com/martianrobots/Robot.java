package com.martianrobots;

import com.martianrobots.model.Orientation;
import com.martianrobots.model.Position;

public class Robot {

    private Position currentPosition;
    private Orientation currentOrientation;
    private final String instructions;

    public Robot(Position currentPosition, Orientation currentOrientation, String instructions) {
        this.currentPosition = currentPosition;
        this.currentOrientation = currentOrientation;
        this.instructions = instructions;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Orientation getCurrentOrientation() {
        return currentOrientation;
    }

    public void setCurrentOrientation(Orientation currentOrientation) {
        this.currentOrientation = currentOrientation;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "currentPosition=" + currentPosition +
                ", currentOrientation=" + currentOrientation +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
