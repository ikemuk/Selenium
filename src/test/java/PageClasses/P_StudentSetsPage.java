package PageClasses;

import LibraryClasses.findElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ikeo on 30/01/14.
 */
public class P_StudentSetsPage {


    WebDriver selenium;
    findElements pageTitle = new findElements();


    public P_StudentSetsPage(WebDriver selenium){

        this.selenium = selenium;


    }


    public WebElement pageTitle(){
        String locator = "#lListTitle";

        WebElement studentTitle = pageTitle.findElementByCss(selenium, "#lListTitle");

        return studentTitle;

    }

    public Boolean isStudentSetPageDisplayed(){
        String locator = "#lListTitle";

        WebElement studentTitle = pageTitle.findElementByCss(selenium, "#lListTitle");

        return studentTitle.getText().equalsIgnoreCase("Student Sets");

    }
}
