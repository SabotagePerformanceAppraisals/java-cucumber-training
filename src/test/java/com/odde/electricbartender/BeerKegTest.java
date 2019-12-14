package com.odde.electricbartender;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeerKegTest {

    @Test
    public void keg_total_capacity_is_50_liters() {
        BeerKeg beerKeg = new BeerKeg();
        assertEquals(50 * 1000, beerKeg.totalCapacityInMilliliters());
    }

}