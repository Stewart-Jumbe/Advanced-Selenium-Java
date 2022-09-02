package com.qualitest.sjumbe.horizontalsliderstests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.HorizontalSlidersPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSlidersTests extends TestUtilities {

    @Test
    public void sliderTest(){
        log.info("Executing Slider Test");

        //Nagivating to Slider Page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        HorizontalSlidersPage horizontalSlidersPage = welcomePage.clickHorizontalSlidersLink();

        //Setting Slider value
        sleep(2000);
        horizontalSlidersPage.setSliderTo("2");
        sleep(2000);

        //Verifying Slider value
        Assert.assertEquals(horizontalSlidersPage.getSliderValue(),"2",
                "Didnt get the expected slider value, retrieved value is "+horizontalSlidersPage.getSliderValue());
    }
}
