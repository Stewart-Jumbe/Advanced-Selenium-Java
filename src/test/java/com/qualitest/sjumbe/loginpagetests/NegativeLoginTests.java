package com.qualitest.sjumbe.loginpagetests;

import com.qualitest.sjumbe.base.CsvDataProviders;
import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.LoginPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {



    @Test(priority = 1,dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void negativeLogInTest(Map<String,String> testData) {


        // Name in the CSV file is shown on the right
        String num = testData.get("num");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage=testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting negativeLoginTest #" +num+" for "+description);

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        log.info("Main page is opened.");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // enter username and password
        loginPage.negativelogIn(username, password);


        // Verifications
        loginPage.waitForErrorMessage();//waiting 5 secs for message to appear

        String actualErrorMessage = loginPage.getInvalidCredntialsMsg();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }


}