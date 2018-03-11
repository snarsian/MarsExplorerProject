package com.martianrobots;

import com.martianrobots.model.Position;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsSurfaceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void throwsExceptionIfXCoordinateOfTopRightPositionPassedIsOutOfRange() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Top Right Position Coordinates cannot be greater than 50");
        new MarsSurface(51, 2);
    }

    @Test
    public void throwsExceptionIfYCoordinateOfTopRightPositionPassedIsOutOfRange() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Top Right Position Coordinates cannot be greater than 50");
        new MarsSurface(1, 60);
    }

    @Test
    public void shouldReturnTrueIfPositionPassedIsWithinBounds() {
        MarsSurface marsSurface = new MarsSurface(5, 2);
        assertThat(marsSurface.isWithinBounds(position(2, 2))).isEqualTo(true);
    }

    @Test
    public void shouldReturnTrueIfPositionPassedIsOnTheEdgeOfBounds() {
        MarsSurface marsSurface = new MarsSurface(5, 2);
        assertThat(marsSurface.isWithinBounds(position(5, 2))).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfPositionPassedIsNotWithinBounds() {
        MarsSurface marsSurface = new MarsSurface(5, 2);
        assertThat(marsSurface.isWithinBounds(position(2, 3))).isEqualTo(false);
    }

    @Test
    public void shouldReturnTrueIfPositionIsMarkedToBeIgnored() {
        MarsSurface marsSurface = new MarsSurface(5, 2);
        Position position = position(3, 3);
        marsSurface.addPositionsToAvoid(position);
        assertThat(marsSurface.isPositionMarkedToBeIgnored(position)).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfPositionIsNotMarkedToBeIgnored() {
        MarsSurface marsSurface = new MarsSurface(5, 2);
        Position position = position(3, 3);
        assertThat(marsSurface.isPositionMarkedToBeIgnored(position)).isEqualTo(false);
    }
}
