package com.stepDefinitions;

import com.pages.AddCustomerTabPage;
import com.qa.util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddCustomerTabPageSteps {
    private final AddCustomerTabPage addCustomerPage = new AddCustomerTabPage(DriverFactory.getDriver());

    @When("user see {string} field")
    public void user_see_field(String field) {
        Assert.assertTrue(addCustomerPage.fieldVisible(field));
    }

    @When("user add the following customers")
    public void user_fill_up_the_with_the_following(DataTable dataTable) {
        List<List<String>> info = dataTable.asLists(String.class);
        addCustomerPage.fillOutFields(info);
    }

}
