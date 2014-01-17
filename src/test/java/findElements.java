import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by ikeo on 17/01/14.
 */
public class findElements {


    public Select dropdown(WebDriver selenium, String locator){

        Select select = new Select(selenium.findElement(By.id(locator)));

        return select;


    }

    public WebElement findElementById(WebDriver selenium, String locator){

        return selenium.findElement(By.id(locator));
    }

    public List<WebElement> findElementsByCss(WebDriver selenium, String locator){

        return selenium.findElements(By.cssSelector(locator));
    }


}
