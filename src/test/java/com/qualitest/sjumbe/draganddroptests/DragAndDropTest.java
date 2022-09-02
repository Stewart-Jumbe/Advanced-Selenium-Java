package com.qualitest.sjumbe.draganddroptests;

import com.qualitest.sjumbe.base.TestUtilities;
import com.qualitest.sjumbe.pages.DragAndDropPage;
import com.qualitest.sjumbe.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestUtilities {

    @Test
    public void dragAtoBTest(){
        log.info( "Executing DragAToBTest");

        //Nagivating to drag and drop page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        DragAndDropPage dragAndDropPage=welcomePage.clickDragAndDropLink();

        //Drag box A and Drop it on box B
        dragAndDropPage.dragAtoB();

        //Verify correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: "+columnAText);

        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"), "Column B headr should be A, but it is: "+columnBText);
    }
}
