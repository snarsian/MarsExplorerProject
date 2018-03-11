package com.martianrobots;

import com.martianrobots.model.Orientation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.martianrobots.Robot.robot;
import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsExplorerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

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
        MarsExplorer explorer = new MarsExplorer(5, 3);
        Robot robot = robot(position(1, 1), Orientation.E, "F");
        explorer.addRobot(robot);
        explorer.explore();

        assertThat(robot.getCurrentPosition()).isEqualTo(position(2, 1));
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.getFinalResult()).isEqualTo("2 1 E");
    }

    @Test
    public void testIfRobotCanMoveWithMultipleInstructions() {
        MarsExplorer explorer = new MarsExplorer(5, 3);
        Robot robot = robot(position(1, 1), Orientation.E, "RFRFRFRF");
        explorer.addRobot(robot);
        explorer.explore();

        assertThat(robot.getCurrentPosition()).isEqualTo(position(1, 1));
        assertThat(robot.getCurrentOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.getFinalResult()).isEqualTo("1 1 E");
    }

    @Test
    public void testIfRobotFallsOfTheEdgeItOutputsWordLostAndTheCurrentRobotIgnoresThatPosition() {
        MarsExplorer explorer = new MarsExplorer(5, 3);
        Robot robot1 = robot(position(3, 2), Orientation.N, "FRRFLLFFRRFLL");
        explorer.addRobot(robot1);

        Robot robot2 = robot(position(0, 3), Orientation.W, "LLFFFLFLFL");
        explorer.addRobot(robot2);

        explorer.explore();

        assertThat(robot1.getCurrentPosition()).isEqualTo(position(3, 3));
        assertThat(robot1.getCurrentOrientation()).isEqualTo(Orientation.N);
        assertThat(robot1.isLost()).isEqualTo(true);
        assertThat(robot1.getFinalResult()).isEqualTo("3 3 N LOST");

        assertThat(robot2.getCurrentPosition()).isEqualTo(position(2, 3));
        assertThat(robot2.getCurrentOrientation()).isEqualTo(Orientation.S);
        assertThat(robot2.isLost()).isEqualTo(false);
        assertThat(robot2.getFinalResult()).isEqualTo("2 3 S");
    }

    @Test
    public void throwExceptionIfRobotCannotBeConstructedAsPositionPassedExceedsTheTopRightPosition() {
        MarsExplorer explorer = new MarsExplorer(1, 2);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("X, Y (2, 2) coordinates are invalid");
        explorer.addRobot(robot(position(2, 2), Orientation.N, "LRF"));
    }

    @Test
    public void throwExceptionIfRobotCannotBeConstructedAsPositionPassedAreLessThanLowerLeftCoordinate() {
        MarsExplorer explorer = new MarsExplorer(1, 2);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("X, Y (-1, 2) coordinates are invalid");
        explorer.addRobot(robot(position(-1, 2), Orientation.N, "LRF"));
    }

    @Test
    public void throwExceptionIfRobotCannotBeConstructedAsIncorrectInstructionsArePassed() {
        MarsExplorer explorer = new MarsExplorer(1, 2);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Invalid instructions LRT passed");
        explorer.addRobot(robot(position(0, 2), Orientation.N, "LRT"));
    }

    @Test
    public void throwExceptionIfRobotCannotBeConstructedAsInstructionLengthIsGreaterThan100() {
        MarsExplorer explorer = new MarsExplorer(1, 2);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Empty instructions or length greater than 100");
        explorer.addRobot(robot(position(0, 2), Orientation.N, "LRFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
    }

    @Test
    public void throwExceptionIfRobotCannotBeConstructedAsInstructionIsNull() {
        MarsExplorer explorer = new MarsExplorer(1, 2);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Empty instructions or length greater than 100");
        explorer.addRobot(robot(position(0, 2), Orientation.N, null));
    }

    @Test
    public void throwExceptionIfRobotCannotBeConstructedAsInstructionIsEmpty() {
        MarsExplorer explorer = new MarsExplorer(1, 2);
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Empty instructions or length greater than 100");
        explorer.addRobot(robot(position(0, 2), Orientation.N, ""));
    }
}
