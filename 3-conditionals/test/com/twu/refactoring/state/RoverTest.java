package com.twu.refactoring.state;

import org.junit.Test;

import static com.twu.refactoring.state.Direction.NORTH;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverTest {
    @Test
    public void shouldNavigateRoverBasedOnInstructions() {
        Position position = new Rover(1, 1, NORTH).navigate("RMLM");
        assertThat(position, is(new Position(2, 2, NORTH)));
    }
}
