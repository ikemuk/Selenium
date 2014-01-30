package TestClasses;

import PageClasses.P_LoginPage;
import PageClasses.P_MainMenuPage;
import PageClasses.P_ProgrammeOfStudtiesPage;
import PageClasses.P_StudentSetsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by ikeo on 28/01/14.
 */
public class TestCase4 {
    WebDriver selenium;

    @BeforeTest
    public void setUp(){

        selenium = new FirefoxDriver();


    }


    @AfterTest
    public void  tearDown(){
        // selenium.quit();
    }

    @BeforeMethod
    public void startBrowser(){
        selenium.get("http://vpc-hy-08r2-03/WDC/login.aspx");
    }

    @Test
    /*1. Navigate to the view programme List page
    * 2. Select a programme of studies randomly from the Department dropdown
    * 3. If a pos exist then check for the Edit button, click on the Edit
    * 4. Check the view and update pos details page
    * 5. Confirm the pos
    * 6. Save and close, verify the pos is confirmed
    * 7. Repeat for another pos  */

     public void ProgrammeOfStudies(){

        P_LoginPage loginPage = new P_LoginPage(selenium);

        P_MainMenuPage mainMenuPage = loginPage.login("WDC", "meandmymonkey");

        if(mainMenuPage.isActivitiesBtnDisplayed()){

            P_ProgrammeOfStudtiesPage posPage = mainMenuPage.clickPOSBtn();

            if(posPage.isPOSPageDisplayed()){

                posPage.selectDepartment();




            }
        }



    }
}
