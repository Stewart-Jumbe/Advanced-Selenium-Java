package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePageObject {

    //Attribute
    private By checkbox = By.xpath("//input[@type='checkbox']");

    //Constructor
    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get List of all checkboxes and check if unchecked
     */
    public void selectAllCheckboxes() {
        log.info("Checking all unchecked checkboxes");

        //populating a list with all elements that were found with checkbox locator
        List<WebElement> checkboxes = findAll(checkbox);

        //Checking that checkboxes are selected and clicking on them if not
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();//using generic click method
            }
        }
    }

    /**
     * Verify all available checkboxes are checked. If at least on unchecked, return false
     */
    public boolean areAllCheckboxesChecked() {
        log.info("Verify that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }


}
