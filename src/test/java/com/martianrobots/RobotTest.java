package com.martianrobots;

import com.martianrobots.command.LeftCommand;
import com.martianrobots.command.RightCommand;
import com.martianrobots.model.Orientation;
import org.junit.Test;

import static com.martianrobots.Robot.robot;
import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {

    private Robot robot = robot(position(1, 2), Orientation.N, "L");

    @Test
    public void shouldReturnCurrentRobotPosition() {
        assertThat(robot.getCurrentPosition()).isEqualTo(position(1,2));
    }

    @Test
    public void shouldReturnCurrentRobotOrientation() {
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    public void shouldReturnInstructions() {
        assertThat(robot.getInstructions()).isEqualTo("L");
    }

    @Test
    public void shouldReturnCommandsAddedToRobot() {
        robot.addCommands("LR");
        assertThat(robot.getCommands().size()).isEqualTo(2);
        assertThat(robot.getCommands().get(0)).isInstanceOfAny(LeftCommand.class, RightCommand.class);
        assertThat(robot.getCommands().get(1)).isInstanceOfAny(LeftCommand.class, RightCommand.class);
    }
}