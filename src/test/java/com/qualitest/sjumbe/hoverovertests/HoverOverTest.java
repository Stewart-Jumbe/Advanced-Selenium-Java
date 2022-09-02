package com.qualitest.sjumbe.hoverovertests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.HoverOverPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOverTest extends TestUtilities {

    @Test
    public void hoverOverTest(){
        log.info("Executing Hover Over Test");

        // navigating to hover over page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        HoverOverPage hoverOverPage =welcomePage.clickHoverLink();


        //Open User 2 profile
        int num = 2;
        hoverOverPage.openUSerProfile(2);

        //Verify correct user profile opened
        Assert.assertTrue(hoverOverPage.getCurrrentUrl().contains("/users/2"),
                "Url of opened page is not expected User " + num + "page url" );
    }
}
