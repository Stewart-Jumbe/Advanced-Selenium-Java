package com.qualitest.sjumbe.loginpagetests;

import com.qualitest.sjumbe.base.CsvDataProviders;
import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.LoginPage;
import com.qualitest.sjumbe.pages.SecureAreaPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class PositiveLoginTests extends TestUtilities {

    @Test(dataProvider = "csvReader",dataProviderClass = CsvDataProviders .class)
    public void positiveLoginTest(Map<String,String> testData) {

        // Name in the CSV file is shown on the right
        String num = testData.get("num");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedSuccessMessage=testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting logIn test");


        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        takeScreenshot("welcomePage opened");
        log.info("Main page is opened.");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        takeScreenshot("LoginPage opened");

        //Add new cookie
        Cookie ck = new Cookie("username","tomsmith","the-internet.herokuapp.com","/",null);
        loginPage.setCookie(ck);

        // enter username and password
        SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
        takeScreenshot("SecurePage opened");

        //Get cookies
        String usernameCk =secureAreaPage.getCookie("username");
        log.info("Username cookie: "+usernameCk);
        String session = secureAreaPage.getCookie("rack.session");
        log.info("Session cookie: " + session);

        // verifications
        // new url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        Assert.assertEquals(secureAreaPage.getCurrrentUrl(), secureAreaPage.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureAreaPage.checkPresenceOfLogOutButton(),
                "logOutButton is not visible.");

        // Verification of successful login
        String actualSuccessMessage = secureAreaPage.readSecureAreaMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
