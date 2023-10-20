package com.stepDefinitions;

import com.pages.BankManagerPage;
import com.qa.util.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BankManagerPageSteps {

    private final BankManagerPage bankManagerPage = new BankManagerPage(DriverFactory.getDriver());

    @Then("user see {string} button in managers page")
    public void user_see_button(String btn) {
        Assert.assertTrue(bankManagerPage.buttonVisible(btn));
    }
    @When("user click {string} button")
    public void user_click_button(String btn) {
        bankManagerPage.userClickBtn(btn);
    }
}
