package com.martianrobots.command;

import com.martianrobots.MarsSurface;
import com.martianrobots.Robot;
import com.martianrobots.model.Position;

public class ForwardCommand implements Command {

    public void execute(Robot robot, MarsSurface marsSurface) {
        Position nextPosition = robot.getCurrentPosition().calculateNextPosition(robot.getCurrentOrientation().getPosition());
        //check if position is within boundary, else we have to record as LOST and also add to the positions to avoid list in MarsSurface
        if (marsSurface.isWithinBounds(nextPosition)) {
            robot.setCurrentPosition(nextPosition);
        }
    }
}
