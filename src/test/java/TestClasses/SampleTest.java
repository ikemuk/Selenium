package TestClasses;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by ikeo on 29/01/14.
 */
public class SampleTest {
    @Test
    public void testMethodOne(){
        Assert.assertTrue(true);
    }

    @Test
    public void testMethodTwo(){
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods={"testMethodTwo"})
    public void testMethodThree(){
        Assert.assertTrue(true);
    }
}
