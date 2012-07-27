package com.twu.strategy;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countWith(new Predicate() {
            @Override
            public boolean evaluate(int number) {
                return number % 2 == 0;
            }
        });
    }

    public int countOdd() {
        return numbers.length - countEven();
    }

    public int countPositive() {
        return countWith(new Predicate() {
            @Override
            public boolean evaluate(int number) {
                return number >= 0;
            }
        });
    }

    public int countNegative() {
        return numbers.length - countPositive();
    }

    private int countWith(Predicate predicate) {
        int count = 0;
        for (int number : numbers) {
            if (predicate.evaluate(number)) count++;
        }
        return count;
    }

    private static interface Predicate {
        public boolean evaluate(int number);
    }
}
