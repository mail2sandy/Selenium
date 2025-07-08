package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXls {
	
	String path;
	public FileInputStream file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ReadXls(String path){
		this.path = path;
	}

	public int 	getRowCount (String sheetName) throws FileNotFoundException {
		file = new FileInputStream(path);
		try {
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			workbook.close();
			file.close();
			return rowCount;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public int 	getColumnCount (String sheetName, int rowCount) throws FileNotFoundException {
		file = new FileInputStream(path);
		try {
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowCount);
			int cellCount = row.getLastCellNum();
			workbook.close();
			file.close();
			return cellCount;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public String getCellValue(String sheetName, int rowNum, int colNum) {
		
		try {
			file = new FileInputStream(path);
			
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			
			DataFormatter format = new DataFormatter();
			
			return format.formatCellValue(cell);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
				
	}
	
public String[][] getExcelValue(String sheetName) {
		
		try {
			DataFormatter format = new DataFormatter();

			file = new FileInputStream(path);
			
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			int maxRowNumber = sheet.getLastRowNum();
			int maxCellNumber = sheet.getRow(maxRowNumber).getLastCellNum();
			
			String loginData[][] = new String[maxRowNumber][maxCellNumber];
			
			for(int i = 1; i <= maxRowNumber; i++) {
				
				for(int j = 0; j<= maxCellNumber; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					
					loginData[i-1][j] = format.formatCellValue(cell);
					
					
				}
				
			}
			
			return loginData;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
				
	}
	
}
