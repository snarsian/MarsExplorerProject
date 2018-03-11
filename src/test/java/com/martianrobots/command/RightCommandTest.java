package com.martianrobots.command;

import com.martianrobots.Robot;
import com.martianrobots.model.Orientation;
import org.junit.Test;

import static com.martianrobots.Robot.robot;
import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;

public class RightCommandTest {

    @Test
    public void testTheCommandMovesTheOrientationTowardsRight() {
        RightCommand rightCommand = new RightCommand();
        Robot robot = robot(position(1, 1), Orientation.E, "R");
        rightCommand.execute(robot);

        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.S);
    }
}