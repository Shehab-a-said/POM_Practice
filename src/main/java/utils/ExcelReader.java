package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

//bad practice // It`s just how to implement reading excel data,(*** it`s not working in my code here right now ****)
public class ExcelReader {

    private static final String TEST_DATA_PATH = "src/test/resources/test-data/";

    //row and col > 0

    public static String getExcelData(String excelFilename, String sheetName, int rowNum, int colNum) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;

        String cellData;
        try {
            workBook = new XSSFWorkbook(TEST_DATA_PATH + excelFilename);
            sheet = workBook.getSheet(sheetName);
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            return cellData;

        } catch (IOException e) {
            System.out.println("Error reading excel file" + e.getMessage());
            return "";
        }
    }
}
