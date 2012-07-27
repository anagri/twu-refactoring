package com.twu.refactoring;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DateParserTest {
    @Test
    public void shouldThrowExceptionIfYearStringCannotBeParsed() {
        testForInput("111", "Should have failed since the year string is less than 4 characters", "Year string is less than 4 characters");
    }

    @Test
    public void shouldThrowExceptionIfYearIsNotInteger() {
        testForInput("abcd", "Should have failed since the year string is not an integer", "Year is not an integer");
    }

    @Test
    public void shouldThrowExceptionIfYearIsLessThan2000() {
        testForInput("1999", "Should have failed since the year is less than 2000", "Year cannot be less than 2000 or more than 2012");
    }

    @Test
    public void shouldThrowExceptionIfMonthStringCannotBeParsed() {
        testForInput("2012-1", "Should have failed since the month string is less than 2 characters", "Month string is less than 2 characters");
    }

    @Test
    public void shouldThrowExceptionIfMonthIsNotInteger() {
        testForInput("2012-ab", "Should have failed since the month string is not an integer", "Month is not an integer");
    }

    @Test
    public void shouldThrowExceptionIfMonthIsMoreThan12() {
        testForInput("2012-13", "Should have failed since the month is more than 12", "Month cannot be less than 1 or more than 12");
    }

    @Test
    public void shouldThrowExceptionIfDateStringCannotBeParsed() {
        testForInput("2012-12-1", "Should have failed since the date string is less than 2 characters", "Date string is less than 2 characters");
    }

    @Test
    public void shouldThrowExceptionIfDateIsNotInteger() {
        testForInput("2012-12-ab", "Should have failed since the date string is not an integer", "Date is not an integer");
    }

    @Test
    public void shouldThrowExceptionIfDateIsMoreThan31() {
        testForInput("2012-12-32", "Should have failed since the date is more than 31", "Date cannot be less than 1 or more than 31");
    }

    @Test
    public void shouldThrowExceptionIfHourStringCannotBeParsed() {
        testForInput("2012-12-11T0", "Should have failed since the hour string is less than 2 characters", "Hour string is less than 2 characters");
    }

    @Test
    public void shouldThrowExceptionIfHourIsNotInteger() {
        testForInput("2012-12-30Tab", "Should have failed since the hour string is not an integer", "Hour is not an integer");
    }

    @Test
    public void shouldThrowExceptionIfHourIsMoreThan23() {
        testForInput("2012-12-31T24", "Should have failed since the hour is more than 23", "Hour cannot be less than 0 or more than 23");
    }

    @Test
    public void shouldThrowExceptionIfMinuteStringCannotBeParsed() {
        testForInput("2012-12-11T01:1", "Should have failed since the minute string is less than 2 characters", "Minute string is less than 2 characters");
    }

    @Test
    public void shouldThrowExceptionIfMinuteIsNotInteger() {
        testForInput("2012-12-30T01:ab", "Should have failed since the minute string is not an integer", "Minute is not an integer");
    }

    @Test
    public void shouldThrowExceptionIfMinuteIsMoreThan59() {
        testForInput("2012-12-31T23:60", "Should have failed since the minute is more than 59", "Minute cannot be less than 0 or more than 59");
    }

    private void testForInput(String input, String failMessage, String expectedErrorMessage) {
        try {
            new DateParser(input).parse();
            fail(failMessage);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(expectedErrorMessage));
        }
    }

    @Test
    public void shouldParseDateForValidInput() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2012, Calendar.DECEMBER, 31, 23, 59, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();

        Date result = new DateParser("2012-12-31T23:59Z").parse();

        assertThat(result, is(expectedDate));
    }
}
