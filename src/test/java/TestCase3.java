
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void setUp(){
        // Method and Description - static DesiredCapabilities internetExplorer()
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

        //Method and Description - void setCapability(java.lang.String capabilityName, boolean value)
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        //Among the facilities provided by the System class are standard input, standard output, and error output streams; access to externally defined "properties"; a means of loading files and libraries; and a utility method for quickly copying a portion of an array.
        System.setProperty("webdriver.ie.driver", "D:\\Selenium\\driver\\IEDriverServer.exe");

        //InternetExplorerDriver(Capabilities capabilities)
        selenium = new InternetExplorerDriver(capabilities);
        selenium.manage().deleteAllCookies();


    }





    @AfterTest
    public void tearDown(){
        //selenium.quit();
    }

    @Test
    public void selectActivity() throws Exception {

        P_MainMenuPage mm;
        P_ListActivitiesPage la;
        P_EditActivityDetailsPage activityEditPage = null;
        HSSFRichTextString[][] testdata;
        Test_Data data = new Test_Data();

        selenium.get("http://vpc-hy-08r2-03/WDC/login.aspx");
        selenium.manage().window().maximize();

        P_LoginPage lp = new P_LoginPage(selenium);

        mm = lp.login("WDC", "meandmymonkey");

        la = mm.clickActivitiesBtn();

        /*Check if its the list activities page */
        Assert.assertTrue(la.isListActivitiesDisplayed());

        int row = data.rowNumber("Sheet1", "D:\\Selenium\\Test_Data\\Book1.xls");
        testdata = data.readexcelwithPOI("Sheet1", "D:\\Selenium\\Test_Data\\Book1.xls");

        for(int r = 1; r < row; r++){
                la.selectDept(testdata[r][0].toString());


            //Thread.sleep(1000);




                la.selectProgramme(testdata[r][1].toString());
            //Thread.sleep(1000);
                la.selectModule(testdata[r][2].toString());
            //Thread.sleep(1000);
                la.selectActivityTemplate(testdata[r][3].toString());

            //Thread.sleep(1000);

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

                    activityEditPage = la.clickActivityEditButton(al);

                    activityEditPage.enterComment("Testing");

                    activityEditPage.clickSaveBtn();

                    //Assert.assertEquals(activityEditPage.getComment(),"ElmiTesting");
                }

                la = activityEditPage.clickSaveandCloseBtn();


        }



    }

    private void iwait() throws InterruptedException {

        wait(5000);
    }


}
