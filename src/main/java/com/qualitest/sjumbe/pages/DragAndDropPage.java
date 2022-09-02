package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DragAndDropPage extends BasePageObject {

    //Attributes
    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    //Methods

    /**
     * Drag box A and drop it on box B
     */
    public void dragAtoB() {
        log.info("Dragging box A onto box B");
        performDragandDrop(columnA, columnB);
    }

    /**
     * Getting Column A Text
     */
    public String getColumnAText() {
        String text = find(columnA).getText();
        log.info("Column A Text: " + text);
        return text;
    }

    /**
     * Getting Column A Text
     */
    public String getColumnBText() {
        String text = find(columnB).getText();
        log.info("Column A Text: " + text);
        return text;
    }


}
