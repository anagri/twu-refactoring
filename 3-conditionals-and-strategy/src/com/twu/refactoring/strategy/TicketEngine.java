package com.twu.refactoring.strategy;

public class TicketEngine {

    /**
     * <pre>
     * Ticket pricing logic -
     *          Age     Married     Price
     * Male     13      -           20
     *          19      -           25
     *          30      No          40
     *          30      Yes         35
     *          40      No          38
     *          40      Yes         33
     *          55      -           30
     *         >55      -           25
     *  Female  8       -           10
     *          15      -           15
     *          19      -           22
     *          30      No          37
     *          30      Yes         32
     *          40      No          36
     *          40      Yes         31
     *          55      -           30
     *         >55      -           25
     *
     * </pre>
     *
     */
    public int calculatePrice(int age, boolean male, boolean married) {
        if (male) {
            if (age <= 13)
                return 20;
            if (age <= 19)
                return 25;
            if (married) {
                if (age <= 30) return 35;
                if (age <= 40) return 33;
            } else {
                if (age <= 30) return 40;
                if (age <= 40) return 38;
            }
        } else {
            if (age <= 8)
                return 10;
            if (age <= 15)
                return 15;
            if (age <= 19)
                return 22;
            if (married) {
                if (age <= 30) return 32;
                if (age <= 40) return 31;
            } else {
                if (age <= 30) return 37;
                if (age <= 40) return 36;
            }
        }
        if (age <= 55) return 30;
        return 25;
    }
}
