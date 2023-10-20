package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonAction {

    public String getURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void waitAndSendKeys(WebDriver driver, By elem, String info) {
        driver.manage().timeouts().getScriptTimeout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(info);
    }

    public void waitAndClick(WebDriver driver, By elem) {
        driver.manage().timeouts().getScriptTimeout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
    }

    public void waitElementUntilVisible(WebDriver driver, By elem) {
        driver.manage().timeouts().getScriptTimeout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
    }

    public void waitElementUntilInvisible(WebDriver driver, By elem) {
        driver.manage().timeouts().getScriptTimeout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elem));
    }

    public boolean elementIsVisible(WebDriver driver, By elem){
        driver.manage().timeouts().getScriptTimeout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
        return driver.findElement(elem).isDisplayed();
    }
}
