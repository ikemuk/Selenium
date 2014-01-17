import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by ikeo on 15/01/14.
 */
public class TestCase2 {

    WebDriver selenium;

    @BeforeTest

    public void setUp(){
        selenium = new FirefoxDriver();

    }

    @AfterTest
    public void tearDown(){
        //selenium.quit();
    }

    @Test
    public void selectActivity(){

        P_MainMenuPage mm;
        P_ListActivitiesPage la;

        selenium.get("http://vpc-hy-08r2-03/WDC/login.aspx");
        selenium.manage().window().maximize();

        P_LoginPage lp = new P_LoginPage(selenium);

        mm = lp.login("WDC", "meandmymonkey");

        la = mm.clickActivitiesBtn();

        /*Check if its the list activities page */
        Assert.assertTrue(la.isListActivitiesDisplayed());



        la.selectDept("AAD APPL");

        la.selectProgramme("AD002A 2");

        la.selectModule("APPL1301/Y");

        la.selectActivityTemplate("APPL1301/Y L2");




        Assert.assertTrue(la.isDepReportButtonDisplayed());
        Assert.assertTrue(la.isPOSReportButtonDisplayed());
        Assert.assertTrue(la.isModuleReportButtonDisplayed());
        Assert.assertTrue(la.isPOSEditButtonDisplayed());
        Assert.assertTrue(la.isModuleEditButtonDisplayed());
        Assert.assertTrue(la.isTemplateEditButtonDisplayed());
        Assert.assertTrue(la.isTemplateAddButtonDisplayed());
        Assert.assertTrue(la.isTemplateDeleteButtonDisplayed());
        Assert.assertTrue(la.isTemplateGenerateButtonDisplayed());

        /*Check if there is a list of activities from selected filter*/
        int activityList = la.listActivityRowNumber();

        if(activityList > 1){

            List<WebElement> al = la.listActivitySummary();

            P_EditActivityDetailsPage activityEditPage = la.clickActivityEditButton(al);

            activityEditPage.enterComment("Testing");

            activityEditPage.clickSaveBtn();

            Assert.assertEquals(activityEditPage.getComment(),"ElmiTesting");



        }



    }

}
