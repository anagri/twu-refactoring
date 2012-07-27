package com.twu.refactoring.state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @Before
    public void setUp() throws Exception {
        north = Direction.NORTH;
        east = Direction.EAST;
    }

    @Test
    public void shouldTurnEastWhenTurnRightFromNorth() {
        Direction east = north.turnRight();
        assertThat(east, sameInstance(Direction.EAST));
    }

    @Test
    public void shouldTurnWestWhenTurnLeftFromNorth() {
        Direction west = north.turnLeft();
        assertThat(west, sameInstance(Direction.WEST));
    }

    @Test
    public void shouldTurnNorthWhenTurnLeftFromEast() {
        Direction north = east.turnLeft();
        assertThat(north, sameInstance(Direction.NORTH));
    }
}
