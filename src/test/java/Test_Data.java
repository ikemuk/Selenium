import jxl.Workbook;
import org.apache.poi.hssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ikeo on 21/01/14.
 */
public class Test_Data {
    InputStream fileInputStream;
    HSSFWorkbook workbook;
    HSSFSheet worksheet;

    public HSSFRichTextString[][] readexcelwithPOI(String sheet, String filePath)
            throws Exception
    {
        fileInputStream = new FileInputStream(filePath); //Get file in local pc
        workbook = new HSSFWorkbook(fileInputStream); //Get workbook to use for test
        worksheet = workbook.getSheet(sheet); //Get sheet in workbook to use for test



        int rowcount = rowCount(worksheet);
        int colnum = columnCount(worksheet);
        HSSFRichTextString[][] val = new HSSFRichTextString[rowcount + 1][colnum];

        for(int row = 1; row <= rowcount; row++){

        HSSFRow row1 = worksheet.getRow(row);
        //int colCount = columnCount(row1);


                for (int col=0;col < colnum;col++)
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

    private static int rowCount(HSSFSheet wb) throws IOException {
        int rowcount;

        rowcount = wb.getLastRowNum();

        return rowcount;
    }

    private static int columnCount(HSSFSheet wb) throws IOException{
        int colCount;


        HSSFRow row1 = wb.getRow(1);
        colCount = row1.getLastCellNum();

        return colCount;
    }

    public int rowNumber(String sheet, String filePath) throws IOException {
        int rowcount;

        fileInputStream = new FileInputStream(filePath);
        workbook = new HSSFWorkbook(fileInputStream); //Get workbook to use for test
        worksheet = workbook.getSheet(sheet); //Get sheet in workbook to use for test

         rowcount = worksheet.getLastRowNum();

        return rowcount + 1;
    }

    public int columnNumber(int rowNum, String sheet, String filePath) throws IOException{
        int colCount;

        fileInputStream = new FileInputStream(filePath);
        workbook = new HSSFWorkbook(fileInputStream); //Get workbook to use for test
        worksheet = workbook.getSheet(sheet); //Get sheet in workbook to use for test

        HSSFRow row1 = worksheet.getRow(rowNum);
        colCount = row1.getLastCellNum();

        return colCount + 1;
    }
}
