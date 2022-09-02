package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverOverPage extends BasePageObject{

    //Attributes
    private By avatarLocator = By.xpath("//div[@class='figure']");
    private By  viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");
    // "." added to the start of the x path so that it doesnt detect all of the view profile links, but only the the one we want


    public HoverOverPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open specified user profile
     */
    public void openUSerProfile(int i){
        List<WebElement> avatars =findAll(avatarLocator);
        WebElement specifiedUserAvatar = avatars.get(i-1);
        hoverOverElement(specifiedUserAvatar);
        specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
    }
}
