package com.martianrobots;

import com.martianrobots.model.Orientation;
import org.junit.Test;

import static com.martianrobots.Robot.robot;
import static com.martianrobots.model.Position.position;
import static org.junit.Assert.fail;

public class MarsExplorerTest {

    @Test
    public void testIfRobotCanTurnLeft() {
        MarsExplorer marsExplorer = new MarsExplorer(5, 3);
        marsExplorer.addRobot(robot(position(1, 2), Orientation.N, "L"));
        marsExplorer.explore();

        fail("to implement this");
    }
}
