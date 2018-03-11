package com.martianrobots;

import com.martianrobots.command.Command;
import com.martianrobots.model.Orientation;
import com.martianrobots.model.Position;
import com.martianrobots.util.StringToCommandConverter;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private Position currentPosition;
    private Orientation currentOrientation;
    private final String instructions;
    private List<Command> commands = new ArrayList<Command>();
    private boolean lost;

    private Robot(Position currentPosition, Orientation currentOrientation, String instructions) {
        this.currentPosition = currentPosition;
        this.currentOrientation = currentOrientation;
        this.instructions = instructions;
    }

    public static final Robot robot(Position currentPosition, Orientation orientation, String instructions){
        return new Robot(currentPosition, orientation, instructions);
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

    public void addCommands(String instructions) {
        commands = StringToCommandConverter.convert(instructions);
    }

    public List<Command> getCommands() {
        return commands;
    }

    public String getFinalResult() {
        return String.format("%d %d %s%s", currentPosition.getXCoordinate(), currentPosition.getYCoordinate(), currentOrientation, lost ?" LOST":"");
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isLost() {
        return this.lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
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
