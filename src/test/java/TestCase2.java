import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

        MainMenuPage mm;
        ListActivitiesPage la;

        selenium.get("http://vpc-hy-08r2-03/WDC/login.aspx");

        LoginPage lp = new LoginPage(selenium);

        mm = lp.login("WDC", "meandmymonkey");

        la = mm.clickActivitiesBtn();

        Assert.assertTrue(la.isListActivitiesDisplayed());

        la.selectDept("BAL");


    }
}
