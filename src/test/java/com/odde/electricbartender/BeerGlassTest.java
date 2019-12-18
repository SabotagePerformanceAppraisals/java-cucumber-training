package com.odde.electricbartender;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class BeerGlassTest {

    @Test
    public void a_beer_glass_holds_300ml() {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(300, beerGlass.getTotalCapacityInMilliters());
    }

    @Test
    public void a_beer_glass_can_be_filled() {
        BeerGlass beerGlass = new BeerGlass();
        AleKeg keg = new AleKeg();
        keg.fillMyGlass(beerGlass);
        assertNotEquals(0, beerGlass.getRemainingBeerInMilliliters());
    }


}