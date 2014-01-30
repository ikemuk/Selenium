package PageClasses;

import LibraryClasses.findElements;
import org.openqa.selenium.WebDriver;

/**
 * Created by ikeo on 17/01/14.
 */
public class P_EditActivityDetailsPage {
    WebDriver selenium;
    findElements findobjects = new findElements();
    String locator;

    public P_EditActivityDetailsPage(WebDriver selenium) {
        this.selenium = selenium;
        //Get url of page
        String url = this.selenium.getCurrentUrl();

        //get page name using string manipulation
        String[] spliturl = url.split("/");
        String page = spliturl[spliturl.length-1];

        if(!"ActivityEdit.aspx".equalsIgnoreCase(page)){
            String address = null;

            for(int i=0; i < spliturl.length; i++){
                address = address + spliturl[i];
            }
            selenium.get(address);
        }

    }


    public void enterComment(String comment){
      locator = "pComments_ACTIVITYLARGECOMMENT_edit";

        findobjects.findElementById(selenium,locator).sendKeys(comment);


    }


    public P_ListActivitiesPage clickSaveandCloseBtn(){
        locator = "bSaveAndClose";

        findobjects.findElementById(selenium,locator).click();

        return new P_ListActivitiesPage(selenium);

    }

    public void clickSaveBtn(){
        locator = "bSave";

        findobjects.findElementById(selenium,locator).click();


    }

    public String getComment(){
        locator = "pComments";

        return findobjects.findElementById(selenium,locator).getText();
    }

}
