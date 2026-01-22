package ui.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui.core.DriverFactory;
import ui.pages.SpiceJetHomePage;

public class SpiceJetSteps {
    private SpiceJetHomePage home;

    @Given("I open the SpiceJet website")
    public void i_open_the_spicejet_website() {
        home = new SpiceJetHomePage(DriverFactory.getDriver());
        home.open();
    }

    @Given("I accept cookies if prompted")
    public void i_accept_cookies_if_prompted() {
        home.acceptCookiesIfPresent();
    }

    @Then("the SpiceJet homepage should be displayed")
    public void the_spicejet_homepage_should_be_displayed() {
        Assert.assertTrue(home.isLoaded(), "SpiceJet homepage did not look loaded (URL/title check failed).");
    }
}

