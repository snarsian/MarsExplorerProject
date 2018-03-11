package com.martianrobots;

import com.martianrobots.model.Orientation;
import com.martianrobots.model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {

    private Robot robot = new Robot(new Position(1, 2), Orientation.N, "L");

    @Test
    public void shouldReturnCurrentRobotPosition() {
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(1,2));
    }

    @Test
    public void shouldReturnCurrentRobotOrientation() {
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    public void shouldReturnInstructions() {
        assertThat(robot.getInstructions()).isEqualTo("L");
    }

}