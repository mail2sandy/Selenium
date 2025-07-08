package utilities;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name="loginData")
	public String[][] getDataFromExcel() throws FileNotFoundException{
		String path = ".//testData//loginTestData.xlsx";
				
		ReadXls read = new ReadXls(path);
		
		int rowCount = read.getRowCount("Sheet1");
		int colCount = read.getColumnCount("Sheet1", 1);
		
		String loginData[][]= new String[rowCount][colCount];
		
		
		for (int i = 1; i<= rowCount ;i++) {
			
			for(int j = 0; j<= colCount-1; j++) {
				
				loginData[i-1][j] = read.getCellValue("Sheet1",i,j);
			}
			
		}
		return loginData;
		
	}

}
