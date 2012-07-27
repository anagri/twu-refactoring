package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = parse(0, 4, "Year");
        checkRange(year, 2000, 2012, "Year");

        month = parse(5, 7, "Month");
        checkRange(month, 1, 12, "Month");

        date = parse(8, 10, "Date");
        checkRange(date, 1, 31, "Date");

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = parse(11, 13, "Hour");
            checkRange(hour, 0, 23, "Hour");

            minute = parse(14, 16, "Minute");
            checkRange(minute, 0, 59, "Minute");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private void checkRange(int value, int minValue, int maxValue, String fieldName) {
        if (value < minValue || value > maxValue)
            throw new IllegalArgumentException(fieldName + " cannot be less than " + minValue + " or more than " + maxValue);
    }

    private int parse(int fromIndex, int toIndex, String fieldName) {
        try {
            String yearString = dateAndTimeString.substring(fromIndex, toIndex);
            return Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(fieldName + " string is less than " + (toIndex - fromIndex) + " characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " is not an integer");
        }
    }
}
