package com.odde.electricbartender;

/**
 * We'll use the metric system to avoid confusing people who aren't used to traditional/historic units.
 */
public class BeerGlass {
    private static double TOTAL_CAPACITY_IN_MILLITERS = 300.0;

    public double getTotalCapacityInMilliters() {
        return TOTAL_CAPACITY_IN_MILLITERS;
    }
}
