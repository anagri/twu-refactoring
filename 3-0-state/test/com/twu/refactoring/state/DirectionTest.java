package com.twu.refactoring.state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @Before
    public void setUp() throws Exception {
        north = new Direction('N');
        east = new Direction('E');
    }

    @Test
    public void shouldTurnEastWhenTurnRightFromNorth() {
        Direction east = north.turnRight();
        assertThat(east, is(new Direction('E')));
    }

    @Test
    public void shouldTurnRight() {
        assertThat(new Direction('N').turnRight(), is(new Direction('E')));
        assertThat(new Direction('E').turnRight(), is(new Direction('S')));
        assertThat(new Direction('S').turnRight(), is(new Direction('W')));
        assertThat(new Direction('W').turnRight(), is(new Direction('N')));
    }

    @Test
    public void shouldTurnWestWhenTurnLeftFromNorth() {
        Direction west = north.turnLeft();
        assertThat(west, is(new Direction('W')));
    }

    @Test
    public void shouldTurnLeft() throws Exception {
        assertThat(new Direction('N').turnLeft(), is(new Direction('W')));
        assertThat(new Direction('E').turnLeft(), is(new Direction('N')));
        assertThat(new Direction('S').turnLeft(), is(new Direction('E')));
        assertThat(new Direction('W').turnLeft(), is(new Direction('S')));
    }

    @Test
    public void shouldTurnNorthWhenTurnLeftFromEast() {
        Direction north = east.turnLeft();
        assertThat(north, is(new Direction('N')));
    }
}
