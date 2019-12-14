package com.odde.electricbartender;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeerGlassTest {

    @Test
    public void a_beer_glass_holds_300ml() {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(300, beerGlass.getTotalCapacityInMilliters());
    }


}