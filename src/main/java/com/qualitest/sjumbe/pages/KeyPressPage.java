package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressPage extends BasePageObject{

    //Attributes
    private By body = By.xpath("//body");
    private By resultTextLocator = By.id("result");

    //Constructor
    public KeyPressPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

/**
 * Enter given key while on this page
 */
public void pressKey(Keys key){
    log.info("Pressing " +key.name());
    pressKey(body,key);
}

/**
 * Get result text
 */
public String getResultText(){
    String result = find(resultTextLocator).getText();
    log.info("Result text: "+ result);
    return result;
}



}
