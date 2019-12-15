package com.odde.electricbartender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarTest {
    private Bar bar;

    @BeforeEach
    public void setUp() {
       bar = new Bar();
    }

    @Test
    public void bar_has_a_keg_of_ale() {
        AleKeg aleKeg = bar.getAleKeg();
        assertNotNull(aleKeg);
    }

    @Test
    public void we_can_restock_a_keg() {
        AleKeg oldKeg = bar.getAleKeg();
        bar.restockAle();
        AleKeg newKeg = bar.getAleKeg();
        assertNotEquals(oldKeg, newKeg);
    }

    @Test
    public void we_can_wash_the_dishes() {
        bar.washTheDishes();
        // TODO: what to assert?
    }


    @Test
    public void we_can_take_a_beer_glass() {
        BeerGlass beerGlass = bar.takeABeerGlass();
        assertNotNull(beerGlass);
    }

}