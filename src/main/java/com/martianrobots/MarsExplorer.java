package com.martianrobots;

import com.martianrobots.command.Command;

import java.util.ArrayList;
import java.util.List;

public class MarsExplorer {

    private final MarsSurface marsSurface;
    private List<Robot> robots;

    public MarsExplorer(int topRightXCoordinate, int topRightYCoordinate) {
        this.marsSurface = new MarsSurface(topRightXCoordinate, topRightYCoordinate);
        this.robots = new ArrayList<Robot>();
    }

    public void addRobot(Robot robot) {
        //need to validate if the instructions passed in are correct
        robot.addCommands(robot.getInstructions()); //converting instructions to commands after validation
        robots.add(robot);
    }

    public void explore() {
        for (Robot robot : robots) {
            //execute robot commands, for each robot save there positions and also save final position
            for (Command command : robot.getCommands()) {
                command.execute(robot, marsSurface);
            }
        }
    }
}
