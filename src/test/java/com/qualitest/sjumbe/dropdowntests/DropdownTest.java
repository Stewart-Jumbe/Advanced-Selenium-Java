package com.qualitest.sjumbe.dropdowntests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.DropdownPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities {

    @Parameters({"optionValue"})
    @Test
    public void optionTwoTest(int optionValue){
        log.info("Starting Option "+optionValue + " test");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //Click on Dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Select Option 2
        dropdownPage.selectOption(optionValue);

        //Verify Option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        String equalsText = "Option "+optionValue;
        Assert.assertTrue(selectedOption.equals(equalsText), equalsText +" is not selected. Instead selected - " +selectedOption);

    }

}
