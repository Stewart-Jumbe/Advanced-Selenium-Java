package com.qualitest.sjumbe.checkboxespagetests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.CheckboxesPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {


    @Test
    public void selectingTwoCheckboxesTest(){

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
        //sleep(5000);
        //Select All Checkboxes
        checkboxesPage.selectAllCheckboxes();
        sleep(2);

        //Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"Not all Checkboxes are checked");
    }
}
