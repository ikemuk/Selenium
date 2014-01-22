import org.apache.poi.hssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by ikeo on 21/01/14.
 */
public class Test_Data {





    public HSSFRichTextString[][] readexcelwithPOI(String sheet, String filePath)
            throws Exception
    {


        InputStream fileInputStream = new FileInputStream(filePath); //Get file in local pc
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream); //Get workbook to use for test
        HSSFSheet worksheet = workbook.getSheet(sheet); //Get sheet in workbook to use for test

        int rowcount = worksheet.getLastRowNum();
        HSSFRichTextString[][] val = new HSSFRichTextString[1][4];

        for(int row = 1; row <= rowcount; row++){

        HSSFRow row1 = worksheet.getRow(row);
        int colCount = row1.getLastCellNum();


                for (int col=0;col<=colCount;col++)
                {

                    HSSFCell c1 = row1.getCell(col);

                    if(c1.getCellType() == HSSFCell.CELL_TYPE_STRING){
                    HSSFRichTextString data = c1.getRichStringCellValue();
                    val[row][col] = data;
                    }
                    else
                    if(c1.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    HSSFRichTextString data = c1.getRichStringCellValue();
                    val[row][col] = data;
                    }




                }
        }

        return val;
    } // method ends here
}
