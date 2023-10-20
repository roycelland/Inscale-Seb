package com.stepDefinitions;

import com.pages.CustomerPage;
import com.qa.util.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CustomerPageSteps {
    CustomerPage customerPage = new CustomerPage(DriverFactory.getDriver());

    @Then("user see {string} button in customers page")
    public void user_see_button_in_customers_page(String btn) {
        Assert.assertTrue(customerPage.buttonVisible(btn));
    }

    @When("user select {string} as user name")
    public void user_select_as_user_name(String user) {
        customerPage.selectUsername(user);
    }

    @When("user click {string} button in customers page")
    public void user_click_button_in_customers_page(String btn) {
        customerPage.clickButton(btn);
    }

    @When("user select {string} as account number")
    public void user_select_as_account_number(String accNo) {
        customerPage.selectAccNo(accNo);
    }

    @When("user input {string} amount")
    public void user_input_amount(String amount) {
        customerPage.inputAmount(amount);
    }

    @Then("balance will be {string}")
    public void balance_will_be(String balance) {
        Assert.assertTrue(customerPage.balanceIsEqualTo(Float.parseFloat(balance)));
    }

    @Then("successful message will disappear")
    public void successful_message_will_disappear() {
        customerPage.waitMessageToDisappear();
    }
}
