package com.martianrobots;

import com.martianrobots.command.Command;
import com.martianrobots.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MarsExplorer {

    private final MarsSurface marsSurface;
    private List<Robot> robots;
    private Pattern pattern = Pattern.compile("[^LRF]");

    public MarsExplorer(int topRightXCoordinate, int topRightYCoordinate) {
        this.marsSurface = new MarsSurface(topRightXCoordinate, topRightYCoordinate);
        this.robots = new ArrayList<Robot>();
    }

    public void addRobot(Robot robot) {
        //need to validate if the instructions passed in are correct
        validateTheInputParameters(robot.getCurrentPosition(), robot.getInstructions());
        robot.addCommands(robot.getInstructions()); //converting instructions to commands after validation
        robots.add(robot);
    }

    public void explore() {
        for (Robot robot : robots) {
            //execute robot commands, for each robot save there positions and also save final position
            for (Command command : robot.getCommands()) {
                if (!robot.isLost()) {
                    command.execute(robot, marsSurface);
                }
            }
        }
    }

    private void validateTheInputParameters(Position currentPosition, String instructions) {
        if (!coordinatesPassedAreWithinBoundary(currentPosition)) {
            throw new IllegalArgumentException(String.format("X, Y (%d, %d) coordinates are invalid",
                    currentPosition.getXCoordinate(), currentPosition.getYCoordinate()));
        }
        if (instructions == null || instructions.length() == 0 || instructions.length() > 100) {
            throw new IllegalArgumentException("Empty instructions or length greater than 100");
        }
        if (checkIfAnyInvalidInstructionExists(instructions)) {
            throw new IllegalArgumentException(String.format("Invalid instructions %s passed", instructions));
        }
    }

    private boolean coordinatesPassedAreWithinBoundary(Position currentPosition) {
        return marsSurface.isWithinBounds(currentPosition);
    }

    private boolean checkIfAnyInvalidInstructionExists(String instructions) {
        return pattern.matcher(instructions).find();
    }
}
