package com.qualitest.sjumbe.fileuploadtests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.FileUploadPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int num,String fileName){
        log.info("Executing File Upload Test # "+num+" for "+fileName);

        //Navigating to file upload from welcome page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //clicking on File Upload link
        FileUploadPage fileUpload = welcomePage.clickFileUploadLink();

        //Select file
        fileUpload.selectFile(fileName);

        //Click upload button
        fileUpload.clickUploadButton();
        //Get Uploaded files
        String fileNames = fileUpload.getUploadedFilesNames();

        //Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");

    }
}
