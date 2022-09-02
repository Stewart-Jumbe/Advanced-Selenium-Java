package com.qualitest.sjumbe.alertests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.JavaScriptAlertsPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;

public class AlertTest extends TestUtilities {

        @Test(priority = 1)
    public void jsAlertTest() {


        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJSAlertLink();

        //Click on an Alert button on the alert page
        alertsPage.clickAlertButton();


        //Verification of Alert Text
        Assert.assertEquals(alertsPage.getAlertText(), "I am a JS Alert");


        //Accept alert
        alertsPage.acceptAlert();

        //Verification of Result message
        Assert.assertEquals(alertsPage.getResultsMessage(), "You successfully clicked an alert");

    }
    @Parameters({"alertChoice"})
    @Test(priority = 3)
    public void jsConfirmTest(String alertChoice) {
        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJSAlertLink();

        //Click on an Confirm button on the alert page
        alertsPage.clickConfirmButton();

        //Verification of Alert Text
        Assert.assertEquals(alertsPage.getAlertText(), "I am a JS Confirm");

        //Accepting or Canceling alert based on test parameter
        switch (alertChoice.toLowerCase(Locale.ROOT)) {

            case "ok":
                alertsPage.acceptAlert();
                //Verification of Result message
                Assert.assertEquals(alertsPage.getResultsMessage(), "You clicked: Ok");

                break;
            case "cancel":
                alertsPage.dismissAlert();
                //Verification of Result message
                Assert.assertEquals(alertsPage.getResultsMessage(), "You clicked: Cancel");
        }
    }

        @Parameters({"alertChoice"})
        @Test(priority = 2)
        public void jsPromptTest(String alertChoice) {
            //Open Main page
            WelcomePage welcomePage = new WelcomePage(driver, log);
            welcomePage.openPage();

            //Click on Alerts link
            JavaScriptAlertsPage alertsPage = welcomePage.clickJSAlertLink();

            //Click on an Confirm button on the alert page
            alertsPage.clickPromptButton();

            //Verification of Alert Text
            Assert.assertEquals(alertsPage.getAlertText(), "I am a JS prompt");

            //Accepting or Canceling alert based on test parameter
            switch (alertChoice.toLowerCase(Locale.ROOT)) {

                case "ok":
                    alertsPage.typeTextIntoAlert("Alright!!");
                    alertsPage.acceptAlert();
                    //Verification of Result message
                    Assert.assertEquals(alertsPage.getResultsMessage(), "You entered: Alright!!");

                    break;
                case "cancel":
                    alertsPage.typeTextIntoAlert("Good weather");
                    alertsPage.dismissAlert();
                    //Verification of Result message
                    Assert.assertEquals(alertsPage.getResultsMessage(), "You entered: null");
            }


    }
}
