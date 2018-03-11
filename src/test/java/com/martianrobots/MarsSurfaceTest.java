package com.martianrobots;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void shouldCreateMarsSurfaceObjectIfTopRightPositionIsNotOutOfRange() {
        MarsSurface marsSurface = new MarsSurface(5, 2);
        assertThat(marsSurface.getTopRightXCoordinate()).isEqualTo(5);
        assertThat(marsSurface.getTopRightYCoordinate()).isEqualTo(2);
    }
}
