package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSlidersPage extends BasePageObject{

    //Attributes
    private By rangeLocator = By.id("range");//for item which shows the value
    private By sliderLocator = By.tagName("input");


    public HorizontalSlidersPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Move Slider to specified value
     */
    public void setSliderTo (String value) {
        log.info("Moving slider to " + value);

        //Move slider normal method
        //Find the xOffset using given value
        int width = find(sliderLocator).getSize().getWidth();
        //log.info("width value is: "+ width);
        double percent = (Double.parseDouble(value)-2.5)/5;
        //log.info("percent value is: " + percent);
        int xOffset = (int) (width * percent);
        //log.info("xOffset is: "+xOffset);
        Actions action = new Actions(driver);
        action.dragAndDropBy(find(sliderLocator),xOffset,0).build().perform();

        //Workaround method
        //Calculate number of steps
//        int steps = (int) (Double.parseDouble(value) / 0.5);
//
//        //Perform steps
//        pressKey(sliderLocator, Keys.ENTER);
//        for (int i = 0; i < steps; i++) {
//            pressKey(sliderLocator, Keys.ARROW_RIGHT);
//        }
    }

        /**
         * Getting slider value
         */
        public String getSliderValue(){
            String value =find(rangeLocator).getText();
            log.info("Slider value is "+ value);
            return value;
        }



}
