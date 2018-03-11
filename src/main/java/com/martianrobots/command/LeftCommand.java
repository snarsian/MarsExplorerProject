package com.martianrobots.command;

import com.martianrobots.MarsSurface;
import com.martianrobots.Robot;

public class LeftCommand implements Command {

    public void execute(Robot robot, MarsSurface marsSurface) {
        robot.setCurrentOrientation(robot.getCurrentOrientation().turnLeft());
    }
}
