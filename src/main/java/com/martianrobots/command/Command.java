package com.martianrobots.command;

import com.martianrobots.MarsSurface;
import com.martianrobots.Robot;

public interface Command {

    void execute(Robot robot, MarsSurface marsSurface);
}
