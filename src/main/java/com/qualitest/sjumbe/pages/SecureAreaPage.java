package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SecureAreaPage extends BasePageObject {

    //Attributes
    private String pageUrl = "http://the-internet.herokuapp.com/secure";
    //Locators
    By logoutButtonLocator = By.xpath("//a[@class='button secondary radius']");
    By secureAreaMessageLocator = By.id("flash");


    //Constructor
    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);//super is used to relate the protected attributes in the BasePageObject, with the inputs to the constructor in a subclass
    }

    //login button check which returns bool
    public LoginPage logOutOfSecureArea() {
        click(logoutButtonLocator);

        return new LoginPage(driver, log);
    }

    //Method to check if LogOutButton is present on page

    /**
     * Verification if logOutButton is visible on the page
     */
    public Boolean checkPresenceOfLogOutButton() {

        return find(logoutButtonLocator).isDisplayed();
    }

    /**
     * Return login Success message
     */
    public String readSecureAreaMessage() {
        return getText(secureAreaMessageLocator);

    }

    /**
     * Returns page URL of secure login area
     */
    public String getPageUrl() {
        return pageUrl;

    }
}
