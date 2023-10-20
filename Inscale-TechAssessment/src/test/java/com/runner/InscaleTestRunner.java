package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Customer.feature"},
        glue = {"com/stepDefinitions", "com/appHooks"},
        plugin = {"pretty"
//                ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
//      ,dryRun = true
)
public class InscaleTestRunner {
}
