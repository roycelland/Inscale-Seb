package com.qa.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the ThreadLocal driver on the basis of given browser
     */
    public WebDriver init_driver() {

        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();
    }

    /**
     * This is used to get the driver with ThreadLocal
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
