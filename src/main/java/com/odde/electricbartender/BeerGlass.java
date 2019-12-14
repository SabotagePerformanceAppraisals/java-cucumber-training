package com.odde.electricbartender;

/**
 * We'll use the metric system to avoid confusing people who aren't used to traditional/historic units.
 */
public class BeerGlass {
    private static int TOTAL_CAPACITY_IN_MILLITERS = 300;

    public int getTotalCapacityInMilliters() {
        return TOTAL_CAPACITY_IN_MILLITERS;
    }
}
