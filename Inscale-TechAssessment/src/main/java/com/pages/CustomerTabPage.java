package com.pages;

import com.qa.util.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CustomerTabPage extends CommonAction {
    private final WebDriver driver;
    private final By searchBar = By.xpath("//input[@ng-model='searchCustomer']");
    private final By searchList = By.xpath("//tr[@class='ng-scope']");
    private final By customerNames = By.xpath("//td[@class='ng-binding']");

    private final By deleteBtn = By.xpath("//button[@ng-click='deleteCust(cust)']");

    public CustomerTabPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean fieldVisible(String elem) {
        return elementIsVisible(driver, searchBar);
    }

    public boolean verifyAddedCustomer(List<List<String>> info) {
        boolean verifyCustomerIfVisible = false;
        for (int infoCount = 0; infoCount < info.size(); infoCount++) {
            waitAndSendKeys(driver, searchBar, info.get(infoCount).get(0));
            System.out.println("----------------------------------------------------------------"); //LOGS FOR THE LOGIC CHECKING
            System.out.println("USER SEARCHED " + info.get(infoCount).get(0));                      //LOGS FOR THE LOGIC CHECKING
            int custInfoCounter = 0;
            for (int rowInfo = 0; rowInfo < info.size(); rowInfo++) {
                String customerToBeVerified = info.get(infoCount).get(0) + " "
                        + info.get(infoCount).get(1)
                        + " " + info.get(infoCount).get(2);
                String customerInformation = driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter).getText()
                        + " " + driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter + 1).getText()
                        + " " + driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter + 2).getText();
                if (customerToBeVerified.equalsIgnoreCase(customerInformation)) {
                    verifyCustomerIfVisible = true;
                    System.out.println(customerToBeVerified + " &  " + customerInformation);        //LOGS FOR THE LOGIC CHECKING
                    System.out.println("CUSTOMER IS VERIFIED");                                     //LOGS FOR THE LOGIC CHECKING
                    break;
                } else {
                    custInfoCounter = custInfoCounter + 3;
                    verifyCustomerIfVisible = false;
                    System.out.println(customerToBeVerified + " &  " + customerInformation);        //LOGS FOR THE LOGIC CHECKING
                    System.out.println("CUSTOMER NOT FOUND");                                       //LOGS FOR THE LOGIC CHECKING
                }
            }
        }
        return verifyCustomerIfVisible;
    }

    public boolean verifyDeletedCustomer(List<List<String>> info) {
        boolean verifyCustomerIfVisible = false;
        for (int infoCount = 0; infoCount < info.size(); infoCount++) {
            waitAndSendKeys(driver, searchBar, info.get(infoCount).get(0));
            System.out.println("----------------------------------------------------------------"); //LOGS FOR THE LOGIC CHECKING
            System.out.println("USER SEARCHED " + info.get(infoCount).get(0));                      //LOGS FOR THE LOGIC CHECKING
            int custInfoCounter = 0;
            for (int rowInfo = 0; rowInfo < info.size(); rowInfo++) {
                String customerToBeVerified = info.get(infoCount).get(0) + " "
                        + info.get(infoCount).get(1)
                        + " " + info.get(infoCount).get(2);
                String customerInformation = driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter).getText()
                        + " " + driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter + 1).getText()
                        + " " + driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter + 2).getText();
                if (customerToBeVerified.equalsIgnoreCase(customerInformation)) {
                    verifyCustomerIfVisible = true;
                    System.out.println(customerToBeVerified + " &  " + customerInformation);        //LOGS FOR THE LOGIC CHECKING
                    System.out.println("CUSTOMER FOUND");                                     //LOGS FOR THE LOGIC CHECKING
                    break;
                } else {
                    custInfoCounter = custInfoCounter + 3;
                    verifyCustomerIfVisible = false;
                    System.out.println(customerToBeVerified + " &  " + customerInformation);        //LOGS FOR THE LOGIC CHECKING
                    System.out.println("CUSTOMER NOT FOUND");                                       //LOGS FOR THE LOGIC CHECKING
                }
            }
        }
        return verifyCustomerIfVisible;
    }

    public void deleteCustomer (List<List<String>> info) {
        for (int infoCount = 0; infoCount < info.size(); infoCount++) {
            waitAndSendKeys(driver, searchBar, info.get(infoCount).get(0));
            System.out.println("----------------------------------------------------------------"); //LOGS FOR THE LOGIC CHECKING
            System.out.println("USER SEARCHED " + info.get(infoCount).get(0));                      //LOGS FOR THE LOGIC CHECKING
            int custInfoCounter = 0;
            for (int rowInfo = 0; rowInfo < info.size(); rowInfo++) {
                String customerToBeVerified = info.get(infoCount).get(0) + " "
                        + info.get(infoCount).get(1)
                        + " " + info.get(infoCount).get(2);
                String customerInformation = driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter).getText()
                        + " " + driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter + 1).getText()
                        + " " + driver.findElements(searchList).get(rowInfo).findElements(customerNames).get(custInfoCounter + 2).getText();
                if (customerToBeVerified.equalsIgnoreCase(customerInformation)) {
                    driver.findElements(deleteBtn).get(rowInfo).click();
                    System.out.println(customerToBeVerified + " &  " + customerInformation);        //LOGS FOR THE LOGIC CHECKING
                    System.out.println("CUSTOMER IS DELETED");                                      //LOGS FOR THE LOGIC CHECKING
                    break;
                } else {
                    custInfoCounter = custInfoCounter + 3;
                    System.out.println(customerToBeVerified + " &  " + customerInformation);        //LOGS FOR THE LOGIC CHECKING
                    System.out.println("CUSTOMER NOT FOUND");                                       //LOGS FOR THE LOGIC CHECKING
                }
            }
        }
    }
}
