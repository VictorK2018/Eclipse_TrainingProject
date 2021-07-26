package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;


public class ExcelData  {
		
	public String ExcelDataProvider(int sheetNum, int rowNumber, int cellNumber) throws IOException {
	
	//File file = new File("D:\\MyTesting\\April2021-ToolsQA  -Selenium Certification Training\\MyJavaProjects\\TestDataClass14.xls");
	File file = new File(System.getProperty("user.dir") +"//src/test//resources//TestDataClass14.xls");
	FileInputStream inputStream = new FileInputStream(file);

	HSSFWorkbook excelworkbook = new HSSFWorkbook(inputStream); 
	
	// prevent 'excelworkbook' leaking:
	try {
 	
	HSSFSheet sheet = excelworkbook.getSheetAt(sheetNum);
	
	// get all rows in the sheet
    //int rowCount = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
     
    // getting the cell value from rowNumber and cellNumber
    HSSFCell cell = sheet.getRow(rowNumber).getCell(cellNumber);
	        
	// returning the cell value ( any type) as string     
    DataFormatter formatter = new DataFormatter();
    return formatter.formatCellValue(cell);
    //return cell2.getStringCellValue();
    
    // end of 'try' block:
	} finally {
	    excelworkbook.close();     
	}
 
	
	
	
   }	
}

