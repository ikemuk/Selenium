package TestClasses;

import PageClasses.*;
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
    P_ProgrammeOfStudtiesPage posPage;

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
        selenium.manage().window().maximize();
    }

    @Test
    /*1. Navigate to the view programme List page
    * 2. Select a programme of studies randomly from the Department dropdown
    * 3. If a pos exist then check for the Edit button, click on the Edit button
    * 4. Check the update pod view then update pained size then confirms pos
    * 6. Save and close, verify the pos is confirmed
    * 7. Repeat for another pos  */

     public void ProgrammeOfStudies() throws InterruptedException {

        P_LoginPage loginPage = new P_LoginPage(selenium);

        P_MainMenuPage mainMenuPage = loginPage.login("WDC", "meandmymonkey");

        if(mainMenuPage.isActivitiesBtnDisplayed()){

            posPage = mainMenuPage.clickPOSBtn();

            if(posPage.isPOSPageDisplayed()){

                posPage.selectDepartment();

                Thread.sleep(1000);

                int noofPOS = posPage.noOfPOS();

                if( noofPOS > 0){

                    P_UpdateProgramDetailsPage updateProgramDetailsPage = posPage.clickRandomEditButton();

                    //check its update page
                    if(updateProgramDetailsPage.isPOSPageDisplayed())
                    {
                         updateProgramDetailsPage.editPlannedSize("120");
                        //posPage = updateProgramDetailsPage.confirmPOS();


                    }



                }

            }
        }



    }
}
