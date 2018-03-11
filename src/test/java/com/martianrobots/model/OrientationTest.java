package com.martianrobots.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.martianrobots.model.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void shouldReturnOrientations() {
        Assertions.assertThat(values()).containsExactly(N, S, E, W);
    }

    @Test
    public void turnLeftOnNorthOrientationShouldPointToWest() {
        Orientation orientation = Orientation.N;
        assertThat(orientation.turnLeft()).isEqualTo(Orientation.W);
    }

    @Test
    public void turnRightOnNorthOrientationShouldPointToEast() {
        Orientation orientation = Orientation.N;
        assertThat(orientation.turnRight()).isEqualTo(Orientation.E);
    }

    @Test
    public void turnLeftOnSouthOrientationShouldPointToEast() {
        Orientation orientation = Orientation.S;
        assertThat(orientation.turnLeft()).isEqualTo(Orientation.E);
    }

    @Test
    public void turnRightOnSouthOrientationShouldPointToWest() {
        Orientation orientation = Orientation.S;
        assertThat(orientation.turnRight()).isEqualTo(Orientation.W);
    }

    @Test
    public void turnLeftOnEastOrientationShouldPointToNorth() {
        Orientation orientation = Orientation.E;
        assertThat(orientation.turnLeft()).isEqualTo(Orientation.N);
    }

    @Test
    public void turnRightOnEastOrientationShouldPointToSouth() {
        Orientation orientation = Orientation.E;
        assertThat(orientation.turnRight()).isEqualTo(Orientation.S);
    }

    @Test
    public void turnLeftOnWestOrientationShouldPointToSouth() {
        Orientation orientation = Orientation.W;
        assertThat(orientation.turnLeft()).isEqualTo(Orientation.S);
    }

    @Test
    public void turnRightOnWestOrientationShouldPointToNorth() {
        Orientation orientation = Orientation.W;
        assertThat(orientation.turnRight()).isEqualTo(Orientation.N);
    }
}