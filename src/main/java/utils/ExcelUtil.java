package utils;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
public class ExcelUtil {
    public Workbook getWorkbook() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("testdata/testdata.xlsx")){
            Workbook workbook = WorkbookFactory.create(inputStream);
            // Sheet sheet= workbook.getSheet("BookingData");
            return workbook;
        } catch (IOException e) {
            throw new RuntimeException("Unable to load TestData.xlsx", e);
        }
    }
    public Sheet getSheet(String sheetName) {
        Workbook workbook = getWorkbook();
        Sheet sheet= workbook.getSheet(sheetName);
        return sheet;
    }
    public String getCellData(String sheetName,int rowNumber, int columnNumber){
        Sheet sheet=getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }
        Row row= sheet.getRow(rowNumber);
        if(row == null){
            throw new RuntimeException("Row not found: " + rowNumber + " in sheet: " + sheetName);
        }
        Cell cell=row.getCell(columnNumber);
        if(cell ==  null){
            throw new RuntimeException("Cell not found: " + columnNumber + " in row: " + rowNumber + " in sheet: " + sheetName);
        }
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }
    public int getRowCount(String sheetName) {

        Sheet sheet = getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        return sheet.getLastRowNum();
    }
    public int getColumnCount(String sheetName) {
        Sheet sheet = getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        Row row = sheet.getRow(0);
        if (row == null) {
            throw new RuntimeException("Row not found: 0 in sheet: " + sheetName);
        }
        return row.getLastCellNum();
    }

}
