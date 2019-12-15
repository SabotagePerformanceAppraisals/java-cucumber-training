package cucumber.stepdefs;

import com.odde.electricbartender.AleKeg;
import com.odde.electricbartender.Bar;
import com.odde.electricbartender.BeerGlass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class StepDefs {
    private Bar bar = new Bar();

    @Given("Our bar uses {int} liter kegs")
    public void our_bar_uses_x_liter_kegs(int x) {
        int expectedKegCapacityInMilliliters = x * 1000;
        
        AleKeg keg = bar.getAleKeg();
        int actualKegCapacity = keg.totalCapacityInMilliliters();
        assertEquals(expectedKegCapacityInMilliliters, actualKegCapacity);
    }

    @Given("the bar has a full keg of ale")
    public void the_bar_has_a_full_keg_of_ale() {
        bar.restockAle();
    }


    @Given("Our bar uses {int}ml beer glasses")
    public void our_bar_uses_x_ml_beer_glasses(int x) {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(x, beerGlass.getTotalCapacityInMilliters());
    }

    @When("guest orders {int} glasses of ale")
    public void guest_orders_x_glasses_of_ale(int x) {
        for (int ii = 1; ii < x; ii++) {
            guest_orders_an_ale();
        }
    }

    @When("guest orders an ale")
    public void guest_orders_an_ale() {
        BeerGlass beerGlass = bar.takeAGlassOfBeer();
        assertNotNull(beerGlass);
    }

}
