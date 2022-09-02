package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePageObject{

    //Attributes
    private By uploadButtonLinkLocator = By.id("file-submit");
    private By choseFileFieldLocator = By.id("file-upload");
    private By uploadFilesLocator=By.id("uploaded-files");

    public FileUploadPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click Upload Button
     */
    public void clickUploadButton(){
        log.info("clicking Upload Button");
        click(uploadButtonLinkLocator);
    }

    /**
     * Select File to Upload
     */
    public void selectFile(String fileName){
        log.info("Selecting '"+ fileName +"' file from Files Folder");
        //Selecting file
        //String filePath = C:\Users\stewart.jumbe\Downloads\randompic.jpg
        String filePath = System.getProperty("user.dir") +"//src//main//resources//files//"+fileName;
        type(filePath, choseFileFieldLocator);
        log.info("File selected");
    }

    /**
     * Get names of uploaded files
     */
    public String getUploadedFilesNames(){
        String names = find(uploadFilesLocator).getText();
        log.info("Uploaded files: " +names);
        return names;
    }



}
