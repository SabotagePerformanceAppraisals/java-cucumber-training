package com.odde.electricbartender;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeerKegTest {

    @Test
    public void keg_total_capacity_is_50_liters() {
        BeerKeg beerKeg = new BeerKeg();
        assertEquals(50 * 1000, beerKeg.totalCapacityInMilliliters());
    }

    @Test
    public void keg_can_pour_beer() {
        BeerKeg beerKeg = new BeerKeg();
        beerKeg.fillMyGlass(new BeerGlass());
        int expectedRemaining = 49700;
        assertEquals(expectedRemaining, beerKeg.remainingBeerInMilliliters());
    }

}