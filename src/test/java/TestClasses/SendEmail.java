package TestClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ikeo on 29/01/14.
 */
public class SendEmail {

    @Test(dataProvider = "getData")
    public void testMailSending(String to, String sub, String msg){
        //selenium
        System.out.println(to +"----------------"+ sub +"---------------"+ msg );
    }

    @DataProvider
    public Object[][] getData(){
        //row is number of times to execute test
        //columns is number of data in test
       Object [][] data = new Object[2][3];

       //1st row
        data[0][0] = "mark dickens";
        data[0][1] = "hello";
        data[0][2] = "how are you doing";

        //2nd row
        data[1][0] = "hassan elmi";
        data[1][1] = "hi boy yo";
        data[1][2] = "when do we play UT";



       return data;
    }
}
