package cucumber.stepdefs;

import com.odde.electricbartender.AleKeg;
import com.odde.electricbartender.Bar;
import com.odde.electricbartender.BeerGlass;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;


public class StepDefs {
    private Bar bar = new Bar();

    @Given("Our bar uses {int} liter kegs")
    public void our_bar_uses_x_liter_kegs(int x) {
        int expectedKegCapacityInMilliliters = x * 1000;
        
        AleKeg keg = bar.getAleKeg();
        int actualKegCapacity = keg.totalCapacityInMilliliters();
        assertEquals(expectedKegCapacityInMilliliters, actualKegCapacity);
    }

    @Given("Our bar uses {int}ml beer glasses")
    public void our_bar_uses_x_ml_beer_glasses(int x) {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(x, beerGlass.getTotalCapacityInMilliters());
    }

}
