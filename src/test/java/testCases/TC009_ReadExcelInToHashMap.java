package testCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC009_ReadExcelInToHashMap {

	@Test
	public void readExcelInToHashMap() throws IOException {
		//WebDriver driver = new ChromeDriver();
		FileInputStream file = new FileInputStream(".//testData//loginTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(row).getLastCellNum();
		HashMap<String, String> loginData = new HashMap<String, String>();
		
		for(int r =1; r <= row; r++) {
			
			for(int j = 0 ; j < col; j++) {
				loginData.put(sheet.getRow(r).getCell(j).getStringCellValue(), sheet.getRow(r).getCell(j+1).getStringCellValue());
				break;
			}
			
		}
		
		for(Map.Entry mapValue :loginData.entrySet()) {
			System.out.println(mapValue.getKey().toString() + "    "+   mapValue.getValue().toString());
		}
		
		workbook.close();
		file.close();
		
		
	}
	
	@Test
	public void writeInToExcel() throws IOException {
		FileInputStream file = new FileInputStream(".//testData//loginTestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(row).getLastCellNum();
		
		
		for(int r = 1; r <= row; r++) {
			sheet.getRow(r).getCell(2).setCellValue("Consumed");
		}
		
		FileOutputStream fout = new FileOutputStream(".//testData//loginTestData.xlsx");
		
		workbook.write(fout);
		
		String[][] twoDArray = new String[row][col];
		
		for(int r=1; r<=row; r++) {
			for(int j=0; j<col; j++) {
				//System.out.println(sheet.getRow(r).getCell(2).toString());
				twoDArray[r-1][j]=sheet.getRow(r).getCell(j).toString();
			}
		}
		
		System.out.println(Arrays.deepToString(twoDArray));
		
		workbook.close();
		file.close();
		
		
	}
	
}
