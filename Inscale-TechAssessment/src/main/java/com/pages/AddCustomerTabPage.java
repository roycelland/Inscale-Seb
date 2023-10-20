package com.pages;

import com.qa.util.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AddCustomerTabPage extends CommonAction {
    private WebDriver driver;
    private final By firstName = By.xpath("//input[@ng-model='fName']");
    private final By lastName = By.xpath("//input[@ng-model='lName']");
    private final By postCode = By.xpath("//input[@ng-model='postCd']");
    private final By addCustomerBtn = By.xpath("//button[text()='Add Customer']");

    public AddCustomerTabPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean fieldVisible(String field) {
        boolean elemIsVisible = false;
        switch (field.toUpperCase()) {
            case "FIRST NAME":
                waitElementUntilVisible(driver, firstName);
                elemIsVisible = driver.findElement(firstName).isDisplayed();
                break;
            case "LAST NAME":
                waitElementUntilVisible(driver, lastName);
                elemIsVisible = driver.findElement(lastName).isDisplayed();
                break;
            case "POSTAL CODE":
                waitElementUntilVisible(driver, postCode);
                elemIsVisible = driver.findElement(postCode).isDisplayed();
                break;
        }
        return elemIsVisible;
    }

    public void fillOutFields(List<List<String>> info) {
        for(int rowInfo = 0; rowInfo < info.size(); rowInfo++){
            for (int custInfo = 0; custInfo < info.get(rowInfo).size(); custInfo++){
                switch (custInfo){
                    case 0:
                        waitAndSendKeys(driver, firstName, info.get(rowInfo).get(custInfo));
                        break;
                    case 1:
                        waitAndSendKeys(driver, lastName, info.get(rowInfo).get(custInfo));
                        break;
                    case 2:
                        waitAndSendKeys(driver, postCode, info.get(rowInfo).get(custInfo));
                        break;
                }
            }
            waitAndClick(driver, addCustomerBtn);
            driver.switchTo().alert().accept();
        }
    }
}
