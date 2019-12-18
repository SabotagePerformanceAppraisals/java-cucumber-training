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

    @Given("私達のバーでは{int}リットルの樽を使う")  // @Given("Our bar uses {int} liter kegs")
    public void our_bar_uses_x_liter_kegs(int x) {
        int expectedKegCapacityInMilliliters = x * 1000;
        AleKeg keg = bar.getAleKeg();
        assertEquals(expectedKegCapacityInMilliliters, keg.totalCapacityInMilliliters());
    }

    @Given("バーにエールが満タンの樽がある") //@Given("the bar has a full keg of ale")
    public void バーにエールが満タンの樽がある() {
        bar.restockAle();
    }

    @Given("{int}MLのビールグラスを使う")  // @Given("Our bar uses {int}ml beer glasses")
    public void our_bar_uses_x_ml_beer_glasses(int x) {
        assertEquals(x, beerGlass.getTotalCapacityInMilliters());
    }

    @When("お客様が {int} 杯のエールを注文する")
    public void guest_orders_x_glasses_of_ale(int x) {
        for (int ii = 0; ii < x; ii++) {
            guest_orders_an_ale();
        }
    }

    @When("ゲストがエールををオーダーする")
    public void guest_orders_an_ale() {
        beerGlass = bar.takeAGlassOfBeer();
    }

    @Then("ゲストのビールグラスにエールが満タンになる")
    public void ゲストのビールグラスにエールが満タンになる() {
        assertNotEquals(0, beerGlass.getRemainingBeerInMilliliters());
    }

    @Then("樽には {double} リットルが残っている")
    public void 樽には_リットルが残っている(Double x) {
        int expectedBeerRemainingInMilliliters = (int) (x * 1000);
        AleKeg keg = bar.getAleKeg();
        assertEquals(expectedBeerRemainingInMilliliters, keg.remainingBeerInMilliliters());
    }
}
