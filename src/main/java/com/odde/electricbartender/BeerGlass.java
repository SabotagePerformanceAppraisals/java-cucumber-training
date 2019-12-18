package com.odde.electricbartender;

/**
 * We'll use the metric system to avoid confusing people who aren't used to traditional/historic units.
 */
public class BeerGlass {
    private final static int TOTAL_CAPACITY_IN_MILLITERS = 300;
    private int remainingBeer = 0;

    public int getTotalCapacityInMilliters() {
        return TOTAL_CAPACITY_IN_MILLITERS;
    }

    public int getRemainingBeerInMilliliters() {
        return remainingBeer;
    }

    public void fill(int amount) {
        remainingBeer = amount;
    }
}
