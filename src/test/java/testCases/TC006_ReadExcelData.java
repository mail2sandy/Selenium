package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TC006_ReadExcelData extends BaseClass{
	public FileInputStream file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path = ".//testData//loginTestData.xlsx";
	String loginData[][];
	
	@Test
	public void readExcel() {
		
		try {
			DataFormatter format = new DataFormatter();

			file = new FileInputStream(path);
			
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet("sheet1");
			int maxRowNumber = sheet.getLastRowNum();
			int maxCellNumber = sheet.getRow(maxRowNumber).getLastCellNum();
			
			String loginData[][] = new String[maxRowNumber][maxCellNumber];
			
			for(int i = 1; i <= maxRowNumber; i++) {
				
				for(int j = 0; j< maxCellNumber; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					
					loginData[i-1][j] = format.formatCellValue(cell);
					
					
				}
				
			}
			
			System.out.println(Arrays.deepToString(loginData));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	}
