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
}