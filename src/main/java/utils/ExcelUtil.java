package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static final String TEST_DATA_PATH = "./src/test/resources/testdata/api-test-data.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	

	public static Object[][] getTestData(String sheetName) {
		 Object[][] data = null ;
		try {
			FileInputStream fis = new FileInputStream(TEST_DATA_PATH);
			book  = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName); 
			
			data = new Object [sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
			
				for(int i = 0; i < sheet.getLastRowNum(); i++) {  //last row num :  the loop should go up to the last row of the excel.
					for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {  // the inner loop should go up to the last column.
						data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
					} 
				}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
