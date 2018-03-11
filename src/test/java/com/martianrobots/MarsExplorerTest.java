package com.martianrobots;

import com.martianrobots.model.Orientation;
import org.junit.Test;

import static com.martianrobots.Robot.robot;
import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class MarsExplorerTest {

    @Test
    public void testIfRobotCanTurnLeft() {
        MarsExplorer explorer = new MarsExplorer(5, 3);
        Robot robot = robot(position(1, 1), Orientation.E, "L");
        explorer.addRobot(robot);
        explorer.explore();

        assertThat(robot.getCurrentPosition()).isEqualTo(position(1, 1));
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.N);
        assertThat(robot.getFinalResult()).isEqualTo("1 1 N");
    }

    @Test
    public void testIfRobotCanTurnRight() {
        MarsExplorer explorer = new MarsExplorer(5, 3);
        Robot robot = robot(position(1, 1), Orientation.N, "R");
        explorer.addRobot(robot);
        explorer.explore();

        assertThat(robot.getCurrentPosition()).isEqualTo(position(1, 1));
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.getFinalResult()).isEqualTo("1 1 E");
    }

    @Test
    public void testIfRobotCanMoveForward() {
        fail("Yet to be implemented");
    }
}
