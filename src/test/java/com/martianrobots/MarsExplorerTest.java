package com.martianrobots;

import org.junit.Test;

import static org.junit.Assert.fail;

public class MarsExplorerTest {

    @Test
    public void testIfRobotCanTurnLeft() {
        MarsExplorer marsExplorer = new MarsExplorer(5, 3);
        marsExplorer.addRobot(new Robot(1, 2, Orientation.N, "L"));
        marsExplorer.explore();

        fail("to implement this");
    }
}
