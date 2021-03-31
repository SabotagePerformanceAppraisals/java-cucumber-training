package cucumber.stepdefs;

import com.odde.electricbartender.AleKeg;
import com.odde.electricbartender.Bar;
import com.odde.electricbartender.BeerGlass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class StepDefs {
    private Bar bar = new Bar();
    private BeerGlass beerGlass = new BeerGlass();

    @Given("Our bar uses {int} liter kegs")
    public void our_bar_uses_x_liter_kegs(int x) {
        int expectedKegCapacityInMilliliters = x * 1000;
        AleKeg keg = bar.getAleKeg();
        assertEquals(expectedKegCapacityInMilliliters, keg.totalCapacityInMilliliters());
    }

    @Given("the bar has a full keg of ale")
    public void the_bar_has_a_full_keg_of_ale() {
        bar.restockAle();
    }

    @Given("Our bar uses {int}ml beer glasses")
    public void our_bar_uses_x_ml_beer_glasses(int x) {
        assertEquals(x, beerGlass.getTotalCapacityInMilliters());
    }

    @When("guest orders {int} glasses of ale")
    public void guest_orders_x_glasses_of_ale(int x) {
        for (int ii = 0; ii < x; ii++) {
            guest_orders_an_ale();
        }
    }

    @When("guest orders an ale")
    public void guest_orders_an_ale() {
        beerGlass = bar.takeAGlassOfBeer();
    }

    @Then("guest's beer glass has ale")
    public void guests_beer_glass_has_ale() {
        assertNotEquals(0, beerGlass.getRemainingBeerInMilliliters());
    }

    @Then("keg will have {double} liters left")
    public void keg_will_have_x_liters_left(Double x) {
        int expectedBeerRemainingInMilliliters = (int) (x * 1000);
        AleKeg keg = bar.getAleKeg();
        assertEquals(expectedBeerRemainingInMilliliters, keg.remainingBeerInMilliliters());
    }

    @Given("the bar has enough ale")
    public void theBarHasEnoughAle() {
        bar.restockAle();
        bar.getAleKeg();
    }
}
