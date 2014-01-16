import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ikeo on 15/01/14.
 */
public class ListActivitiesPage {
    WebDriver selenium;


    public ListActivitiesPage(WebDriver selenium){

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




    private Select dropdown(String locator){

        Select select = new Select(selenium.findElement(By.id(locator)));

        return select;


    }

    private WebElement object(String locator){

        return selenium.findElement(By.id(locator));
    }
}
