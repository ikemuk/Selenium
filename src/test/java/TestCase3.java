
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



/**
 * Created by ikeo on 21/01/14.
 */
public class TestCase3 {

    WebDriver selenium;

    File fi = new File("D:\\Selenium\\Test_Data\\Book1.xls");

    @BeforeTest

   /* public void setUp(){
        selenium = new FirefoxDriver();

    }*/

    public void setUp(){
        selenium = new FirefoxDriver();

    }


    /*public void setUp() throws MalformedURLException {
        DesiredCapabilities capacity;
        capacity = DesiredCapabilities.firefox();
        capacity.setBrowserName("firefox");
        capacity.setPlatform(Platform.ANY);

        URL url = new URL("http://vpc-hy-w7-au2:4444/wd/hub");

        selenium = new RemoteWebDriver(url, capacity);

    }*/



    @AfterTest
    public void tearDown(){
        //selenium.quit();
    }

    @Test
    public void selectActivity() throws Exception {

        P_MainMenuPage mm;
        P_ListActivitiesPage la;
        HSSFRichTextString[][] testdata;
        testdata = new HSSFRichTextString[1][4];

        Test_Data data = new Test_Data();

        selenium.get("http://vpc-hy-08r2-03/WDC/login.aspx");
        selenium.manage().window().maximize();

        P_LoginPage lp = new P_LoginPage(selenium);

        mm = lp.login("WDC", "meandmymonkey");

        la = mm.clickActivitiesBtn();

        /*Check if its the list activities page */
        Assert.assertTrue(la.isListActivitiesDisplayed());

        //Get test data
        testdata = data.readexcelwithPOI("Sheet1", "D:\\Selenium\\Test_Data\\Book1.xls");


        for(int r = 1; r < 1; r++){
                la.selectDept(testdata[r][0].toString());
                la.selectProgramme(testdata[r][1].toString());
                la.selectModule(testdata[r][2].toString());
                la.selectActivityTemplate(testdata[r][3].toString());

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


}
