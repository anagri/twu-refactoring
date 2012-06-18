package com.twu.strategy;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) count++;
        }
        return count;
    }

    public int countOdd() {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 1) count++;
        }
        return count;
    }
}
