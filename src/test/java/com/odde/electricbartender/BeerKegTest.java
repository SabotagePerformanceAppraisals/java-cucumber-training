package com.odde.electricbartender;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BeerKegTest {

    @Test
    public void a_keg_can_be_created() {
        BeerKeg beerKeg = new BeerKeg();
        assertNotNull(beerKeg);
    }

}