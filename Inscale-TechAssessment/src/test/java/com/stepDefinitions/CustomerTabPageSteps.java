package com.stepDefinitions;

import com.pages.CustomerTabPage;
import com.qa.util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CustomerTabPageSteps {

    CustomerTabPage customerTabPage = new CustomerTabPage(DriverFactory.getDriver());

    @When("user see {string} field in customer tab")
    public void user_see_field_in_customer_tab(String elem) {
        Assert.assertTrue(customerTabPage.fieldVisible(elem));
    }

    @Then("user verify the following customers")
    public void user_verify_the_following_customers(DataTable dataTable) throws InterruptedException {
        List<List<String>> info = dataTable.asLists(String.class);
        Assert.assertTrue(customerTabPage.verifyAddedCustomer(info));
    }

    @When("user will delete the following customers")
    public void user_will_delete_the_following_customers(DataTable dataTable) throws InterruptedException {
        List<List<String>> info = dataTable.asLists(String.class);
        customerTabPage.deleteCustomer(info);
    }
    @Then("user verify the following deleted customers")
    public void user_verify_the_following_deleted_customers(DataTable dataTable) {
        List<List<String>> info = dataTable.asLists(String.class);
        Assert.assertFalse(customerTabPage.verifyDeletedCustomer(info));
    }
}
