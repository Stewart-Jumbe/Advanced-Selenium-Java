package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JSErrorPage extends BasePageObject{

    private String url = "https://the-internet.herokuapp.com/javascript_error";

    public JSErrorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public JSErrorPage openPage(){
        driver.get(url);
        return new JSErrorPage(driver,log);
    }
}
