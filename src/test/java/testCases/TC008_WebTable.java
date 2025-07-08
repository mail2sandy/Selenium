package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC008_WebTable extends BaseClass {
	
	String url = "https://letcode.in/table";
	
	@Test
	public void webtable() throws Exception {
		
		driver.get(url);
		WebElement table = driver.findElement(By.xpath("//div[@class='card']//table[@id='simpletable']//tbody"));
		
		List<WebElement> tableHeader = table.findElements(By.xpath(".//th"));
		
		for(WebElement header : tableHeader) {
			System.out.println(header.getText());
		}
		
		List<WebElement> allRows = table.findElements(By.xpath(".//tr"));
		
System.out.println(allRows.size());

		JavascriptExecutor jsRun = (JavascriptExecutor)driver;
		
		jsRun.executeScript("window.scrollBy(0, 450)", "");
		
		
		for(WebElement tableValue : allRows) {
			
			List<WebElement> column = tableValue.findElements(By.xpath(".//td"));
			
			WebElement firstColumn = column.get(0);
			WebElement secondColumn = column.get(1);
			
			System.out.println(secondColumn.getText());
			
			if(secondColumn.getText().equals("Raj")) {
				
				new Actions(driver).moveToElement(column.get(3).findElement(By.tagName("input"))).perform();
				column.get(3).findElement(By.tagName("input")).click();
				
			}
			
			Thread.sleep(10);
		}
		
		
	}

}
