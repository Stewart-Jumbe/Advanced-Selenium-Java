package com.qualitest.sjumbe.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    //Attributes
    private String pageUrl = "http://the-internet.herokuapp.com/";

    //By locator Attributes
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By jsAlertLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By wysiwygEditorLinkLocator  = By.linkText("WYSIWYG Editor");
    private By keyPressesLinkLocator  = By.linkText("Key Presses");
    private By fileUploadLinkLocator  = By.linkText("File Upload");
    private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
    private By hoverOverLinkLocator = By.linkText("Hovers");
    private By horizontalSlidersLinkLocator = By.linkText("Horizontal Slider");


    //Constructor
    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Methods

    /**
     * Openining WelcomePage with its url
     */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page Opened :-)");
    }

    /**
     * Open LoginPage by Clicking on Form Authentication Link
     */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authenitcation link on Welcome Page");
        click(formAuthenticationLinkLocator);

        return new LoginPage(driver, log);
    }

    /**
     * Open CheckboxesPage by Clicking on Checkboxes link
     */
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    /**
     * Open Dropdown page by clicking on link
     */

    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    /**
     * Open JavaScript Alert page by clicking on link
     */

    public JavaScriptAlertsPage clickJSAlertLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(jsAlertLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver, log);
    }

    /**
     * Open WYSIWYG Editor link
     */
    public EditorPage clickWYSIWYGEditorLink(){
        click(wysiwygEditorLinkLocator);
        return new EditorPage(driver,log);
    }

    /**
     * Open Key Presses link
     */
    public KeyPressPage clickKeyPressesLink(){
        click(keyPressesLinkLocator);
        return new KeyPressPage(driver,log);
    }

    /**
     * Open Key Presses link
     */
    public FileUploadPage clickFileUploadLink(){
        click(fileUploadLinkLocator);
        return new FileUploadPage(driver,log);
    }

    /**
     * Open Drag and Drop link
     */
    public DragAndDropPage clickDragAndDropLink(){
        click(dragAndDropLinkLocator);
        return new DragAndDropPage(driver,log);
    }

    /**
     * Open HoverOver link
     */
    public HoverOverPage clickHoverLink(){
        click(hoverOverLinkLocator);
        return new HoverOverPage(driver,log);
    }

    /**
     * Open Horizontal Sliders link
     */
    public HorizontalSlidersPage clickHorizontalSlidersLink(){
        click(horizontalSlidersLinkLocator);
        return new HorizontalSlidersPage(driver,log);
    }





}

