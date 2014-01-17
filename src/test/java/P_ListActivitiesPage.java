import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by ikeo on 15/01/14.
 */
public class P_ListActivitiesPage {
    WebDriver selenium;
    findElements find = new findElements();


    public P_ListActivitiesPage(WebDriver selenium){

        this.selenium = selenium;
    }

    public boolean isListActivitiesDisplayed(){
        String locator = "lActivityListTitle";

        WebElement ListActivity = object(locator);

        return ListActivity.isDisplayed();

    }

    public void selectDept(String dep){

        String locator = "dlDepartment";

        Select DepDrpDwn = dropdown(locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectProgramme(String dep){

        String locator = "dlPOS";

        Select DepDrpDwn = dropdown(locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectModuleStatus(String dep){

        String locator = "dlStatus";

        Select DepDrpDwn = dropdown(locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectModule(String dep){

        String locator = "dlModule";

        Select DepDrpDwn = dropdown(locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public void selectActivityTemplate(String dep){

        String locator = "dlTemplate";

        Select DepDrpDwn = dropdown(locator);

        DepDrpDwn.selectByVisibleText(dep);


    }

    public boolean isDepReportButtonDisplayed(){

        String locator = "bDepartmentReport";
        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isPOSReportButtonDisplayed(){
        String locator = "bPOSReports";

        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isModuleReportButtonDisplayed(){
        String locator = "bModuleReports";

        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isPOSEditButtonDisplayed(){

        String locator = "bPOSEdit";
        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isModuleEditButtonDisplayed(){

        String locator = "bModuleEdit";
        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isTemplateEditButtonDisplayed(){

        String locator = "bTemplateEdit";
        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isTemplateAddButtonDisplayed(){

        String locator = "bAddTemplate";
        WebElement btn = object(locator);

        return btn.isDisplayed();

    }

    public boolean isTemplateDeleteButtonDisplayed(){

        String locator = "bDeleteTemplate";
        WebElement btn = object(locator);
        return btn.isDisplayed();

    }

    public boolean isTemplateGenerateButtonDisplayed(){

        String locator = "bTemplateGenerate";
        WebElement btn = object(locator);
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
        int i = 1 + (int) (Math.random() * ((ListofActivities.size() - 1) + 1));

        WebElement row = ListofActivities.get(i);
        WebElement  btn = row.findElement(By.cssSelector("input[id^='bEditpdetail_']"));
        btn.click();

        return new P_EditActivityDetailsPage(selenium);

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
