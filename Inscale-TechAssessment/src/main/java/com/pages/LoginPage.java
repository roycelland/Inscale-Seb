package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.util.CommonAction;

public class LoginPage extends CommonAction{
    private final WebDriver driver;
    private final By bankManagerLogin = By.xpath("//button[text()='Bank Manager Login']");
    private final By customerLogin = By.xpath("//button[text()='Customer Login']");

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public String getLoginPageUrl(){
        return getURL(driver);
    }

    public void clickLogin (String role){
        switch (role.toUpperCase()) {
            case "MANAGER":
                waitAndClick(driver,bankManagerLogin);
                break;
            case "CUSTOMER":
                waitAndClick(driver,customerLogin);
                break;
        }
    }
}
