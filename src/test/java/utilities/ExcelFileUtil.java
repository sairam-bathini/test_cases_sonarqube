package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtil {
    Workbook wb;

    // constructor for reading excelpath
    public ExcelFileUtil(String Excelpath) throws Throwable {
        FileInputStream fi = new FileInputStream(Excelpath);
        wb = WorkbookFactory.create(fi);
    }

    // count number of rows in a sheet
    public int rowcount(String sheetname) {
        return wb.getSheet(sheetname).getLastRowNum();
    }


    // method for reading cell data
    public String getcelldata(String Sheetname, int row, int column) {
        String data;
        if (wb.getSheet(Sheetname).getRow(row).getCell(column).getCellType() == CellType.NUMERIC) {
            int celldata = (int) wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
            data = String.valueOf(celldata);
        } else {
            data = wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
        }
        return data;
    }


}
