package com.martianrobots.model;

import org.junit.Test;

import static com.martianrobots.model.Position.position;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void validateTheXAndYCoordinatesAreSetCorrectly() {
        Position position = position(5, 2);
        assertThat(position.getXCoordinate()).isEqualTo(5);
        assertThat(position.getYCoordinate()).isEqualTo(2);
    }

    @Test
    public void validateIfTheNextPositionIsCalculatedByIncrementingXCoordinate() {
        Position position = position(5, 2);
        Position nextPosition = position.calculateNextPosition(position(1, 0));
        assertThat(nextPosition.getXCoordinate()).isEqualTo(6);
        assertThat(nextPosition.getYCoordinate()).isEqualTo(2);
    }

    @Test
    public void validateIfTheNextPositionIsCalculatedByDecrementingYCoordinate() {
        Position position = position(5, 2);
        Position nextPosition = position.calculateNextPosition(position(0, -1));
        assertThat(nextPosition.getXCoordinate()).isEqualTo(5);
        assertThat(nextPosition.getYCoordinate()).isEqualTo(1);
    }
}