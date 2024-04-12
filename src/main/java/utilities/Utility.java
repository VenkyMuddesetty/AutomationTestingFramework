package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Utility {
	

	public void readDataFromPropertiesFile() throws Exception {
		
		String propPath="C:\\SUBHASH FILES\\Course\\Java-Selenium Course\\Batch3\\Files\\config.properties";
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("browserName"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}
	
	@Test
	public void readDataFromExcelFile() {
		//How to read data from excel file
		
		//C:\SUBHASH FILES\Course\Java-Selenium Course\Batch3\Files\batch3.xlsx
		//Open workbook
		//Open sheet
		//Read rows
		//Read columns
		//Go to 1st row and 1st column then read Cell
		//Print Cell Data
			
			XSSFWorkbook wb=null;
			try {
				FileInputStream fis = new FileInputStream("C:\\SUBHASH FILES\\Course\\Java-Selenium Course\\Batch3\\Files\\batch3.xlsx");
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//XSSFSheet sheet = wb.getSheetAt(0);
			XSSFSheet sheet = wb.getSheet("Login");
			
			int rowCount = sheet.getLastRowNum();//4
			int colCount = sheet.getRow(0).getLastCellNum();//2
			
			for(int i=0; i<rowCount; i++) {
				XSSFRow row = sheet.getRow(i+1);
				for(int j=0; j<colCount; j++) {
					XSSFCell cell = row.getCell(j);
					
					switch(cell.getCellType()) {
					case STRING: System.out.print(cell.getStringCellValue());
								 break;
								 
					case NUMERIC: System.out.print(cell.getNumericCellValue());
								 break;
					}
					System.out.print("   |   ");
				}
				System.out.println();
			}
	}
}
