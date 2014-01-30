package TestClasses;

import org.testng.annotations.*;

/**
 * Created by ikeo on 29/01/14.
 */
public class TestCase5 {
    @BeforeTest
    public void openDB(){

        System.out.println("Open database connection");
    }

    @AfterTest
    public void closeDB(){
        System.out.println("Close database connection");
    }

    @BeforeMethod
    public void openBrowser(){
        System.out.println("Open Browser");

    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close Browser");
    }


    @Test
    public void testLogin(){
        System.out.println("First Test");
    }

    @Test
    public void testHello(){
        System.out.println("Second Test");
    }

    @Test
    public void testHi(){
        System.out.println("Third Test!!!!!");
    }
}
