package com.qualitest.sjumbe.editortests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.EditorPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTest extends TestUtilities {

    @Test
    public void editorTest(){
        log.info("Executing Editor test");

        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Scroll to the bottom
        sleep(2000);
        welcomePage.scrollToBottom();
        sleep(2000);

        //Click on Alerts link
        EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();
        sleep(2000);
        //Get default editor text

        String editorText =editorPage.getEditorText();
        sleep(2000);

        //Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),"Editor default text does not match. Instead it's: "+editorText);
    }
}
