package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject{

    //Attributes
    private By editorLocator = By.id("tinymce");
    private By frame = By.tagName("iframe");

    public EditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get text from TinyCME WYSIWYG Editor
     */
    public String getEditorText(){
        //need to switch to iframe before looking for editorLocator
        switchToFrame(frame);
        waitForVisibilityOf(editorLocator,2);
        String text = find(editorLocator).getText();
        log.info("Text from TinyMCE WYSIWYG Editor: "+ text);
        return text;
    }
}
