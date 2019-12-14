package com.odde.electricbartender;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarTest {
    @Test
    public void a_bar_can_be_created() {
        Bar bar = new Bar();
        assertNotNull(bar);
    }

}