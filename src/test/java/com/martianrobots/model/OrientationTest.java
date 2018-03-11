package com.martianrobots.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.martianrobots.model.Orientation.*;

public class OrientationTest {

    @Test
    public void shouldReturnOrientations() {
        Assertions.assertThat(values()).containsExactly(N, S, E, W);
    }
}