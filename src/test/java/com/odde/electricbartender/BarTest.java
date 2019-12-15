package com.odde.electricbartender;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarTest {

    @Test
    public void bar_has_a_keg_of_ale() {
        Bar bar= new Bar();
        AleKeg aleKeg = bar.getAleKeg();
        assertNotNull(aleKeg);
    }
}