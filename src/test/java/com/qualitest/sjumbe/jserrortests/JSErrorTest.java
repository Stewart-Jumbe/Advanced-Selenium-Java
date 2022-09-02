package com.qualitest.sjumbe.jserrortests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.JSErrorPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class JSErrorTest extends TestUtilities {

    @Test
    public void jsErrorTest(){
        log.info("Starting jsErrorTest");
        SoftAssert softAssert = new SoftAssert();

        //Open JSErrorPage
        JSErrorPage jsErrorPage = new JSErrorPage(driver,log);
        jsErrorPage.openPage();

        //Get Logs
        List<LogEntry> logs = getBrowserLogs();


        //Verifying there are no JavaScript errors in console
        for (LogEntry logEntry:logs){
            if(logEntry.getLevel().toString().equals("SEVERE")){
                softAssert.fail("Severe error: "+logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }
}
