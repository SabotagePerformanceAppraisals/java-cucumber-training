package com.odde.electricbartender;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeerGlassTest {
    @Test
    public void a_beer_class_can_be_created() {
        BeerGlass beerGlass = new BeerGlass();
        assertNotNull( beerGlass );
    }

    @Test
    public void a_beer_glass_holds_300ml() {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(300.0, beerGlass.getTotalCapacityInMilliters());
    }


}