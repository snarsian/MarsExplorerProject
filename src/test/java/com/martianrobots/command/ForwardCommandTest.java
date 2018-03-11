package com.martianrobots.command;

import com.martianrobots.MarsSurface;
import com.martianrobots.Robot;
import com.martianrobots.model.Orientation;
import org.junit.Test;

import static com.martianrobots.Robot.robot;
import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;

public class ForwardCommandTest {

    private ForwardCommand forwardCommand = new ForwardCommand();
    private MarsSurface marsSurface = new MarsSurface(5, 3);

    @Test
    public void testTheCommandMovesForwardAndSetTheNextPosition() {
        Robot robot = robot(position(1, 1), Orientation.E, "F");
        forwardCommand.execute(robot, marsSurface);

        assertThat(robot.getCurrentPosition()).isEqualTo(position(2, 1));
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.E);
    }
}