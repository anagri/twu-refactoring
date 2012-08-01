package com.twu.featureenvy;

public class Receipt {
    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double totalCost() {
        double totalCost = 0;

        // fixed charges
        totalCost += 50;

        // taxi charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? 1.2 : 1.0;
        if(taxi.isAirConditioned()) {
            totalCost += Math.min(10, totalKms) * 20 * peakTimeMultiple;
            totalCost += Math.max(0, totalKms - 10) * 17 * peakTimeMultiple;
        } else {
            totalCost += Math.min(10, totalKms) * 15 * peakTimeMultiple;
            totalCost += Math.max(0, totalKms - 10) * 12 * peakTimeMultiple;
        }

        return totalCost * (1 + 0.1);
    }
}
