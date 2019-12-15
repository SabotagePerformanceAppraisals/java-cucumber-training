package com.odde.electricbartender;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    private AleKeg aleKeg;
    List<String> list1 = new ArrayList<String>();
    private List<BeerGlass> beerGlasses;

    public AleKeg getAleKeg() {
        return aleKeg;
    }

    public void restockAle() {
        aleKeg = new AleKeg();
    }

    public Bar() {
        restockAle();
        washTheDishes();
    }

    public void washTheDishes() {
        beerGlasses = new ArrayList<BeerGlass>();
        for (int ii = 0; ii < 100 ; ii++)
            beerGlasses.add(new BeerGlass());
        System.out.println("Dishes are clean.");
    }

    public BeerGlass takeABeerGlass() {
        return beerGlasses.remove(beerGlasses.size()-1);
    }
}
