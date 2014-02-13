package PageClasses;

import LibraryClasses.findElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ikeo on 03/02/14.
 */
public class P_UpdateProgramDetailsPage {

    WebDriver selenium;
    findElements findObject = new findElements();

    public P_UpdateProgramDetailsPage(WebDriver selenium){

        this.selenium = selenium;
    }

    public Boolean isPOSPageDisplayed(){
        String locator = "#lPOSFormInstruction";

        WebElement posTitle = findObject.findElementByCss(selenium, locator);

        return posTitle.getText().equalsIgnoreCase("View Programme List");

    }

    public void editPlannedSize(String value){
        String locator = "pPosDetail_POSPlannedSize_edit";

        WebElement plannedSizeTxtBx = findObject.findElementById(selenium, locator);

        plannedSizeTxtBx.sendKeys(value);

    }

    public void confirmPOS(){
        String locator = "pPosDetail_POSStatus_edit";

        Select statusSelectBx = findObject.dropdown(selenium, locator);

        statusSelectBx.selectByValue("Confirmed");

    }

    public P_ProgrammeOfStudtiesPage clickSaveAndCloseButton(){
        String locator = "bSaveAndClose";

        findObject.findElementById(selenium, locator).click();

        return new P_ProgrammeOfStudtiesPage(selenium);
    }
}
