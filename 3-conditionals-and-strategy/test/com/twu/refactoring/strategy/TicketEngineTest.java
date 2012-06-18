package com.twu.refactoring.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TicketEngineTest {

    private TicketEngine ticketEngine;

    @Before
    public void setUp() throws Exception {
        ticketEngine = new TicketEngine();
    }

    @Test
    public void shouldReturnCorrectPriceOfTicketsForMales() {
        assertForCorrectPrice(13, true, false, 20);
        assertForCorrectPrice(19, true, false, 25);
        assertForCorrectPrice(30, true, false, 40);
        assertForCorrectPrice(30, true, true, 35);
        assertForCorrectPrice(40, true, false, 38);
        assertForCorrectPrice(40, true, true, 33);
        assertForCorrectPrice(55, true, true, 30);
        assertForCorrectPrice(55, true, false, 30);
        assertForCorrectPrice(60, true, true, 25);
        assertForCorrectPrice(60, true, false, 25);
    }

    @Test
    public void shouldReturnCorrectPriceOfTicketsForFemales() {
        assertForCorrectPrice(8, false, false, 10);
        assertForCorrectPrice(15, false, false, 15);
        assertForCorrectPrice(19, false, false, 22);
        assertForCorrectPrice(30, false, false, 37);
        assertForCorrectPrice(30, false, true, 32);
        assertForCorrectPrice(40, false, false, 36);
        assertForCorrectPrice(40, false, true, 31);
        assertForCorrectPrice(55, false, true, 30);
        assertForCorrectPrice(55, false, false, 30);
    }

    private void assertForCorrectPrice(int age, boolean male, boolean married, int expectedPrice) {
        int actualPrice = ticketEngine.calculatePrice(age, male, married);
        assertThat(actualPrice, is(expectedPrice));
    }
}
