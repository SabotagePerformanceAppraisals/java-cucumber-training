package cucumber.stepdefs;

import com.odde.electricbartender.BeerGlass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.driver.WebDriverWrapper;
import cucumber.site.GildedRoseSite;

import static org.junit.Assert.assertEquals;


public class StepDefs {
    private final GildedRoseSite site = new GildedRoseSite();
    private final WebDriverWrapper driver = site.getDriver();

    @When("I load the page")
    public void i_load_the_page() throws InterruptedException {
        site.visit("/inventory/list");
    }

    @Then("I can see the welcome message")
    public void i_can_see_the_welcome_message() {
        driver.pageShouldContain("inventory");

    }

    @Given("Our bar uses {int}ml glasses")
    public void our_bar_uses_ml_glasses(int int1) {
        BeerGlass beerGlass = new BeerGlass();
        assertEquals(int1, beerGlass.getTotalCapacityInMilliters());
    }

}
