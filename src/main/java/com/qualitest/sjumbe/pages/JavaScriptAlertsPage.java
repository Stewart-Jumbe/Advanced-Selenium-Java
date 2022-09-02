package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class JavaScriptAlertsPage extends BasePageObject {

    //Attributes
    private By jsAlertButton = By.xpath("//button[@onclick='jsAlert()']");
    private By jsConfirmButton = By.xpath("//button[@onclick='jsConfirm()']");
    private By jsPromptButton = By.xpath("//button[@onclick='jsPrompt()']");
    private By resultMessage = By.id("result");


    //Constructor
    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Methods

    /**
     * Click JS Alert Button
     */
    public void clickAlertButton() {
        log.info("Clicking JS Alert Button");
        click(jsAlertButton);
    }

    /**
     * Click JS Confirm Button
     */
    public void clickConfirmButton() {
        log.info("Clicking JS Confirm Button");
        click(jsConfirmButton);
    }

    /**
     * Click JS Prompt Button
     */
    public void clickPromptButton() {
        log.info("Clicking JS Prompt Button");
        click(jsPromptButton);
    }

    /**
     * Switch to alert and get it's message
     */
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert text says " + alertText);
        return alertText;
    }


    /**
     * Switch to alert and press OK
     */
public void acceptAlert(){
    log.info("Switching to alert and pressing OK");
    Alert alert = switchToAlert();
    alert.accept();
}
/**
 * Switch to alert and press Cancel
 */
public void dismissAlert(){
    log.info("Switching to alert and pressing cancel");
    Alert alert= switchToAlert();
    alert.dismiss();
}

/**
 * Gets Result message
 */

public String getResultsMessage(){
    String resultMsg = getText(resultMessage);
return resultMsg;
}

/**
 * Type text into alert
 */
public void typeTextIntoAlert(String text){
    log.info("Typing "+text+" into alert");
    Alert alert=switchToAlert();
    alert.sendKeys(text);
}


}
