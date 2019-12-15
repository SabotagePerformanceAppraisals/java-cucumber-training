package com.odde.electricbartender;

public class BeerKeg {
    static final private int TOTAL_CAPACITY_IN_MILLILITERS = 50 * 1000;
    private int remaining_beer_in_milliliters = TOTAL_CAPACITY_IN_MILLILITERS;

    public int totalCapacityInMilliliters() {
        return TOTAL_CAPACITY_IN_MILLILITERS;
    }

    public void fillMyGlass(BeerGlass beerGlass) {
        remaining_beer_in_milliliters -= beerGlass.getTotalCapacityInMilliters();
    }

    public int remainingBeerInMilliliters() {
        return remaining_beer_in_milliliters;
    }
}
