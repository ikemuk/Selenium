package LibraryClasses;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.TimesPanel;

import java.sql.Time;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by ikeo on 17/01/14.
 */
public class findElements {


    public Select dropdown(WebDriver selenium, String locator) {
        WebDriverWait _wait = new WebDriverWait(selenium, 30);
        //Select select = new Select(selenium.findElement(By.id(locator)));

        Select select = new Select(_wait.until(visibilityOfElementLocated(By.id(locator))));
            // return select;



        return select;
    }





    public WebElement findElementById(WebDriver selenium, String locator){

        //Tell driver to wait
        WebDriverWait _wait = new WebDriverWait(selenium, 10);

        WebElement object = _wait.until(visibilityOfElementLocated(By.id(locator)));
        //selenium => selenium.findElement(By.id(locator))
        return object;
     }




    public List<WebElement> findElementsByCss(WebDriver selenium, String locator){

        //selenium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Tell driver to wait
        WebDriverWait _wait = new WebDriverWait(selenium, 10);
        List<WebElement> object = _wait.until(visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
        return object;
    }


    public  WebElement findElementByCss(WebDriver selenium, String locator){
        WebDriverWait _wait = new WebDriverWait(selenium, 10);
        WebElement object = _wait.until(visibilityOfElementLocated(By.cssSelector(locator)));
        return object;
    }

    public WebElement findElementsByCss_webElement(WebElement object, String locator){


        return object.findElement(By.cssSelector(locator));
    }

    public  int getRandomNumberFrom(int min, int max) {
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;

        return randomNumber;

    }
}
