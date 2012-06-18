package com.twu.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberCruncherTest {
    @Test
    public void shouldCountEvenNumbers() {
        int evens = new NumberCruncher(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).countEven();
        assertThat(evens, is(5));
    }

    @Test
    public void shouldCountOddNumbers() {
        int odds = new NumberCruncher(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).countOdd();
        assertThat(odds, is(6));
    }
}
