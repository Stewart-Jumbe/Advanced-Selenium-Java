package com.qualitest.sjumbe.multiplewindowstests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.NewWindowPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import com.qualitest.sjumbe.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends TestUtilities {

    @Test
    public void multipleWindownsTest(){
        log.info("Executing Multiple Windows Test");

        //Opening welcome page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //Nagivating to MultipleWindows page
        WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();

        //clicking on new 'click here' link
        windowsPage.openNewWindow();

        //Find and Switch to new window page
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();
        log.info("Page source is: "+pageSource);

        //Verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"),"New page source does not contain 'New Window, it has "+pageSource+" instead");


    }

}
