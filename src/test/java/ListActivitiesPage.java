import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ikeo on 15/01/14.
 */
public class ListActivitiesPage {
    WebDriver selenium;


    public ListActivitiesPage(WebDriver selenium){

        this.selenium = selenium;
    }

    public boolean isListActivitiesDisplayed(){
        String locator = "lActivityListTitle";

        WebElement ListActivity = label(locator);

        return ListActivity.isDisplayed();

    }

    public void selectDept(String dep){

        String locator = "dlDepartment";

        Select DepDrpDwn = dropdown(locator);

        DepDrpDwn.selectByVisibleText(dep);


    }


    private Select dropdown(String locator){

        Select select = new Select(selenium.findElement(By.id(locator)));

        return select;


    }

    private WebElement label(String locator){

        return selenium.findElement(By.id(locator));
    }
}
