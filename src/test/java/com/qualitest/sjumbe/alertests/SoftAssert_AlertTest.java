package com.qualitest.sjumbe.alertests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.JavaScriptAlertsPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class SoftAssert_AlertTest extends TestUtilities {

    @Test(priority = 1)
    public void jsAlertTest() {
        log.info("Starting jsAlert Test");
        SoftAssert softAssert = new SoftAssert();


        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJSAlertLink();

        //Click on an Alert button on the alert page
        alertsPage.clickAlertButton();


        //Verification of Alert Text
        softAssert.assertEquals(alertsPage.getAlertText(), "I am a JS AlertK");


        //Accept alert
        alertsPage.acceptAlert();

        //Verification of Result message
        softAssert.assertEquals(alertsPage.getResultsMessage(), "You successfully clicked an alertK");

        //ensures that i'm alerted if a test fails
        softAssert.assertAll();
    }

    @Parameters({"alertChoice"})
    @Test(priority = 3)
    public void jsConfirmTest(String alertChoice) {

        log.info("Starting jsConfirm Test");
        SoftAssert softAssert = new SoftAssert();

        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJSAlertLink();

        //Click on an Confirm button on the alert page
        alertsPage.clickConfirmButton();

        //Verification of Alert Text
        softAssert.assertEquals(alertsPage.getAlertText(), "I am a JS ConfirmK");

        //Accepting or Canceling alert based on test parameter
        switch (alertChoice.toLowerCase(Locale.ROOT)) {

            case "ok":
                alertsPage.acceptAlert();
                //Verification of Result message
                softAssert.assertEquals(alertsPage.getResultsMessage(), "You clicked: Ok");

                break;
            case "cancel":
                alertsPage.dismissAlert();
                //Verification of Result message
                softAssert.assertEquals(alertsPage.getResultsMessage(), "You clicked: Cancel");
        }

        //ensures that i'm alerted if a test fails
        softAssert.assertAll();
    }

    @Parameters({"alertChoice"})
    @Test(priority = 2)
    public void jsPromptTest(String alertChoice) {
        log.info("Starting jsPrompt Test");
        SoftAssert softAssert = new SoftAssert();

        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJSAlertLink();

        //Click on an Confirm button on the alert page
        alertsPage.clickPromptButton();

        //Verification of Alert Text
        softAssert.assertEquals(alertsPage.getAlertText(), "I am a JS prompt");

        //Accepting or Canceling alert based on test parameter
        switch (alertChoice.toLowerCase(Locale.ROOT)) {

            case "ok":
                alertsPage.typeTextIntoAlert("Alright!!");
                alertsPage.acceptAlert();
                //Verification of Result message
                softAssert.assertEquals(alertsPage.getResultsMessage(), "You entered: Alright!!");

                break;
            case "cancel":
                alertsPage.typeTextIntoAlert("Good weather");
                alertsPage.dismissAlert();
                //Verification of Result message
                softAssert.assertEquals(alertsPage.getResultsMessage(), "You entered: null");
        }
        //ensures that i'm alerted if a test fails
        softAssert.assertAll();

    }
}
