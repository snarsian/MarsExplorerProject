package com.martianrobots.command;

import com.martianrobots.Robot;

public class LeftCommand implements Command {

    public void execute(Robot robot) {
        robot.setCurrentOrientation(robot.getCurrentOrientation().turnLeft());
    }
}
