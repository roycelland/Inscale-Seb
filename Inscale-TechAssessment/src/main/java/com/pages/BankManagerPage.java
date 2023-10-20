package com.pages;

import com.qa.util.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage extends CommonAction {
    private final WebDriver driver;
    private final By addCustomer = By.xpath("//button[@ng-click='addCust()']");
    private final By openAccount = By.xpath("//button[@ng-click='openAccount()']");
    private final By showCust = By.xpath("//button[@ng-click='showCust()']");

    public BankManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean buttonVisible(String button) {
        switch (button.toUpperCase()) {
            case "ADD CUSTOMER":
                return elementIsVisible(driver, addCustomer);
            case "OPEN ACCOUNT":
                return elementIsVisible(driver, openAccount);
            case "CUSTOMER":
                return elementIsVisible(driver, showCust);
            default:
                return false;
        }
    }

    public void userClickBtn(String button) {
        switch (button.toUpperCase()) {
            case "ADD CUSTOMER":
                waitElementUntilVisible(driver, addCustomer);
                waitAndClick(driver, addCustomer);
                break;
            case "OPEN ACCOUNT":
                waitElementUntilVisible(driver, openAccount);
                waitAndClick(driver, openAccount);
                break;
            case "CUSTOMER":
                waitElementUntilVisible(driver, showCust);
                waitAndClick(driver, showCust);
                break;
        }
    }
}
