package com.twu.refactoring;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineItemTest {
    @Test
    public void shouldGenerateStringFormatForLineItemWithDetails() {
        String string = new LineItem("milk", 10.0, 2).toString();
        assertThat(string, is("milk\t10.0\t2\t20.0\n"));
    }
}
