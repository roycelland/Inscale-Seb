package com.pages;

import com.qa.util.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends CommonAction {

    private final WebDriver driver;
    private final By userNameDBox = By.xpath("//select[@id='userSelect']");
    private final By loginBtn = By.xpath("//button[@type='submit']");
    private final By accountSelect = By.xpath("//select[@id='accountSelect']");
    private final By transactionBtn = By.xpath("//button[@ng-click='transactions()']");
    private final By creditBtn = By.xpath("//button[@ng-click='deposit()']");
    private final By debitBtn = By.xpath("//button[@ng-click='withdrawl()']");
    private final By amountTxt = By.xpath("//input[@type='number']");
    private final By balanceLabel = By.xpath("//div[@ng-hide='noAccount']//strong");
    private final By message = By.xpath("//span[@ng-show='message']");
    private float prevBalance;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean balanceIsEqualTo(Float expectedBalance) {
        return expectedBalance == Float.parseFloat(driver.findElements(balanceLabel).get(1).getText());
    }

//    public float balanceCompute(String transType, float amount) {
//        float balance = Float.parseFloat(driver.findElements(balanceLabel).get(1).getText());
//        switch (transType.toUpperCase()) {
//            case "DEPOSIT":
//                if (balance == amount) {
//                    prevBalance = balance;
//                    return balance;
//                } else {
//                    System.out.println(balance);
//                    System.out.println(amount);
//                    System.out.println(balance + amount);
//                    prevBalance = balance + amount;
//                    return balance + amount;
//                }
//            case "WITHDRAW":
//                if (balance == amount) {
//                    return amount;
//                } else {
//                    System.out.println(balance);
//                    System.out.println(amount);
//                    System.out.println(balance - amount);
//                    return prevBalance - amount;
//                }
//            default:
//                return 0;
//        }
//    }

    public boolean buttonVisible(String button) {
        switch (button.toUpperCase()) {
            case "USER SELECT":
                return elementIsVisible(driver, userNameDBox);
            case "TRANSACTION":
                return elementIsVisible(driver, transactionBtn);
            default:
                return false;
        }
    }

    public void inputAmount(String amt) {
        waitAndSendKeys(driver, amountTxt, amt);
    }
    public void waitMessageToDisappear(){
        waitElementUntilInvisible(driver, message);
    }

    public void selectUsername(String user) {
        Select userN = new Select(driver.findElement(userNameDBox));
        userN.selectByVisibleText(user);
    }

    public void selectAccNo(String acc) {
        Select accNo = new Select(driver.findElement(accountSelect));
        accNo.selectByVisibleText(acc);
    }

    public void clickButton(String btn) {
        switch (btn.toUpperCase()) {
            case "LOGIN":
                waitElementUntilVisible(driver, loginBtn);
                waitAndClick(driver, loginBtn);
                break;
            case "DEPOSIT TAB":
                waitElementUntilVisible(driver, creditBtn);
                waitAndClick(driver, creditBtn);
                break;
            case "WITHDRAWAL TAB":
                waitElementUntilVisible(driver, debitBtn);
                waitAndClick(driver, debitBtn);
                break;
            case "WITHDRAW":
                waitElementUntilVisible(driver, loginBtn);
                waitAndClick(driver, loginBtn);
                break;
            case "DEPOSIT":
                waitElementUntilVisible(driver, loginBtn);
                waitAndClick(driver, loginBtn);
                break;
            default:
                break;
        }
    }
}
