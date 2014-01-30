package PageClasses;

import LibraryClasses.findElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by ikeo on 30/01/14.
 */
public class P_ProgrammeOfStudtiesPage {


    WebDriver selenium;
    findElements findObject = new findElements();


    public P_ProgrammeOfStudtiesPage(WebDriver selenium){

        this.selenium = selenium;


    }

    public WebElement pageTitle(){
        String locator = "#lListTitle";

        WebElement posTitle = findObject.findElementByCss(selenium, locator);

        return posTitle;

    }

    public Boolean isPOSPageDisplayed(){
        String locator = "#lListTitle";

        WebElement posTitle = findObject.findElementByCss(selenium, locator);

        return posTitle.getText().equalsIgnoreCase("View Programme List");

    }

    public void selectDepartment(){

        String loccator = "dlDepartment";

        Select DepartmentDropDown = findObject.dropdown(selenium, loccator);

        List<WebElement> departmentList = DepartmentDropDown.getOptions();

        int departmentNumber = departmentList.size();

        DepartmentDropDown.selectByIndex(findObject.getRandomNumberFrom(0,departmentNumber));

    }
}
