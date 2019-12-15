package cucumber.stepdefs;

import com.odde.electricbartender.BeerGlass;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;


public class StepDefs {

    @Given("Our bar uses {int}ml beer glasses")
    public void our_bar_uses_ml_beer_glasses(int int1) {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(int1, beerGlass.getTotalCapacityInMilliters());
    }

}
