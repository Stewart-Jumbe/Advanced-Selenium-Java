package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    //Attributes
    //Locator Attributes
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginInButtonLocator = By.className("radius");
    private By invalidCredentialsMsg = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Constructor

    //Methods

    /**
     * Execute Log in
     */
    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing LogIn with username: [" + username + "] and password [" + password + "]");
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(loginInButtonLocator);

        return new SecureAreaPage(driver, log);
    }

    public void negativelogIn(String username, String password) {
        log.info("Executing Negative LogIn with username: [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginInButtonLocator);
    }

   public String getInvalidCredntialsMsg(){
        return getText(invalidCredentialsMsg);
   }

   public void waitForErrorMessage(){
     waitForVisibilityOf(invalidCredentialsMsg,5);
    }
}
