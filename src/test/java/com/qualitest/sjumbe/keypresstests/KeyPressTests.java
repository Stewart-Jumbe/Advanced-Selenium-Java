package com.qualitest.sjumbe.keypresstests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.KeyPressPage;

import com.qualitest.sjumbe.pages.WelcomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTests extends TestUtilities {

    @Test
    public void pressKeyTest() {


        log.info("Starting pressKeysTest");

        //Open KeyPressesPage
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        KeyPressPage keyPressPage = welcomePage.clickKeyPressesLink();

        //Push keyboard key
        keyPressPage.pressKey(Keys.ENTER);

        //Get Result text
        String result = keyPressPage.getResultText();

        //Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You enterd ENTER' but it is " + " " + result);

    }

    @Test
    public void pressKeyWithActionsTest(){
        log.info("Executing pressKeyWithActionsTest");

        //open KeyPressesPage
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        KeyPressPage keyPressPage = welcomePage.clickKeyPressesLink();

        //Push Keyboard Key
        keyPressPage.pressKeyWithActions(Keys.SPACE);

        //Get Result text
        String result = keyPressPage.getResultText();

        //Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is "+result);

    }

}
