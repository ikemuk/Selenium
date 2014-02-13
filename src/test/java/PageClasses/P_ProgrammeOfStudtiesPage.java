package PageClasses;

import LibraryClasses.findElements;
import org.openqa.selenium.By;
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

        String locator = "dlDepartment";

        Select DepartmentDropDown = findObject.dropdown(selenium, locator);

        List<WebElement> departmentList = DepartmentDropDown.getOptions();

        int departmentNumber = departmentList.size();

        DepartmentDropDown.selectByIndex(findObject.getRandomNumberFrom(0,departmentNumber));

    }

    public List<WebElement> getListOfPOS(){
        //Gets the all the pos list objects from
        String locator = "#pListPanel";
        String locator1 = "div[id^= 'pdetail_']";


        WebElement posPane = findObject.findElementByCss(selenium, locator);

        List<WebElement> posList = findObject.findElementsByCss_listWebElement(posPane, locator1);

        return posList;

    }

    public int noOfPOS(){
        //Gets number of pos in pane

        List<WebElement> posList = this.getListOfPOS();

        return posList.size();

    }

    public WebElement selectRandomPOS(){

        List<WebElement> posList = this.getListOfPOS(); //gets list of pos in pane

        int noOfPOS = this.noOfPOS(); //gets number of pos in pane

        int y = findObject.getRandomNumberFrom(0, noOfPOS - 1);

        WebElement posNo = posList.get(y);

        return posNo;

    }

    public P_UpdateProgramDetailsPage clickRandomEditButton(){

        String locator = "input[id^='bEditpdetail_']";

        /*List<WebElement> posList = this.getListOfPOS(); //gets list of pos in pane

        int noOfPOS = this.noOfPOS();

        int y = findObject.getRandomNumberFrom(0, noOfPOS - 1);

        WebElement posNo = posList.get(y);

        WebElement btn = posNo.findElement(By.className("SmallButton")); */

        WebElement i = findObject.findElementsByCss_webElement(this.selectRandomPOS(), locator);

        i.click();

        return new P_UpdateProgramDetailsPage(selenium);

    }



    public String checkSelectedDepartment(){

        String locator = "dlDepartment";

        Select DepartmentDropDown = findObject.dropdown(selenium, locator);

        String department = DepartmentDropDown.getFirstSelectedOption().getText();

        return  department;

    }
}
