package com.stepDefinitions;

import com.pages.LoginPage;
import com.qa.util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",loginPage.getLoginPageUrl());
    }

    @When("^user click \"([^\"]*)\" login$")
    public void user_click_login(String role) {
        loginPage.clickLogin(role);
    }

}
