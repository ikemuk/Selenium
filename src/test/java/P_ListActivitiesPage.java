import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * Created by ikeo on 15/01/14.
 */
public class P_ListActivitiesPage {
    WebDriver selenium;
    findElements find = new findElements();


    public P_ListActivitiesPage(WebDriver selenium){

        this.selenium = selenium;

        //Get url of page
        String url = this.selenium.getCurrentUrl();

        //get page name using string manipulation
        String[] spliturl = url.split("/");
        String page = spliturl[spliturl.length-1];

        if(!"activityList.aspx".equalsIgnoreCase(page)){
            String address = null;

            for(int i=0; i < spliturl.length; i++){
                address = address + spliturl[i];
            }
            selenium.get(address);
        }
    }

    public boolean isListActivitiesDisplayed(){
        String locator = "lActivityListTitle";

        WebElement ListActivity = find.findElementById(selenium, locator);

        return ListActivity.isDisplayed();

    }

    public void selectDept(String dep){

        String locator = "dlDepartment";

        //Select DepDrpDwn = dropdown(locator);
        Select DepDrpDwn = find.dropdown(selenium,locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectProgramme(String dep){

        String locator = "dlPOS";

        //Select DepDrpDwn = dropdown(locator);
        Select DepDrpDwn = find.dropdown(selenium,locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectModuleStatus(String dep){

        String locator = "dlStatus";

        //Select DepDrpDwn = dropdown(locator);
        Select DepDrpDwn = find.dropdown(selenium,locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectModule(String dep){

        String locator = "dlModule";

        //Select DepDrpDwn = dropdown(locator);
        Select DepDrpDwn = find.dropdown(selenium,locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectActivityTemplate(String dep){

        String locator = "dlTemplate";

        //Select DepDrpDwn = dropdown(locator);
        Select DepDrpDwn = find.dropdown(selenium,locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public boolean isDepReportButtonDisplayed(){

        String locator = "bDepartmentReport";
        //WebElement btn = object(locator);
        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isPOSReportButtonDisplayed(){
        String locator = "bPOSReports";

        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isModuleReportButtonDisplayed(){
        String locator = "bModuleReports";

        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isPOSEditButtonDisplayed(){

        String locator = "bPOSEdit";
        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isModuleEditButtonDisplayed(){

        String locator = "bModuleEdit";
        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isTemplateEditButtonDisplayed(){

        String locator = "bTemplateEdit";
        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isTemplateAddButtonDisplayed(){

        String locator = "bAddTemplate";
        WebElement btn = find.findElementById(selenium, locator);

        return btn.isDisplayed();

    }

    public boolean isTemplateDeleteButtonDisplayed(){

        String locator = "bDeleteTemplate";
        WebElement btn = find.findElementById(selenium, locator);
        return btn.isDisplayed();

    }

    public boolean isTemplateGenerateButtonDisplayed(){

        String locator = "bTemplateGenerate";
        WebElement btn = find.findElementById(selenium, locator);
        return btn.isDisplayed();

    }

    public int listActivityRowNumber(){
        String locator = "#pActivityList>div";
        List<WebElement> pane = find.findElementsByCss(selenium, locator);

        return pane.size();

    }

    public List<WebElement> listActivitySummary(){
        String locator = "#pActivityList>div";
        List<WebElement> pane = find.findElementsByCss(selenium, locator);

        return pane;



    }

    public P_EditActivityDetailsPage clickActivityEditButton(List<WebElement> ListofActivities){

        /*Click on random selected activity edit button */
        //int i = 1 + (int) (Math.random() * ((ListofActivities.size() - 1) + 1));

        int i = getRandomNumberFrom(1,ListofActivities.size() - 1);

        WebElement row = ListofActivities.get(i);
        //WebElement  btn = row.findElement(By.cssSelector("input[id^='bEditpdetail_']"));
        WebElement  btn = find.findElementsByCss_webElement(row, "input[id^='bEditpdetail_']");
        btn.click();

        return new P_EditActivityDetailsPage(selenium);

    }


    public static int getRandomNumberFrom(int min, int max) {
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;

        return randomNumber;

    }

    private Select dropdown(String locator){

        Select select = new Select(selenium.findElement(By.id(locator)));

        return select;


    }

    private WebElement object(String locator){

        return selenium.findElement(By.id(locator));
    }

    private WebElement objectElements(String locator){

        return (WebElement) selenium.findElements(By.cssSelector(locator));
    }
}
