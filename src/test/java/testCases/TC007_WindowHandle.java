package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC007_WindowHandle extends BaseClass{
	
	String loginURL = "https://testautomationu.applitools.com/";
	
	@Test
	public void windowHandle() {
		
		try {
			driver.navigate().to(loginURL);
			Thread.sleep(5);
			String homePage = driver.getWindowHandle();
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.xpath("//div[@class='links']//nav[contains(@class,'nav-links')]//div[@class='nav-item']//a[@class='nav-link external']")).click();
			Thread.sleep(5);			
			Set<String> windowHandle = driver.getWindowHandles();
			
			for(String window : windowHandle) {
				if(window != homePage) {
					driver.switchTo().window(window);
					System.out.println(driver.getCurrentUrl().contains("policy"));
					driver.switchTo().window(homePage).close();
					windowHandle = driver.getWindowHandles();
					driver.switchTo().window(windowHandle.iterator().next());
					System.out.println(driver.getCurrentUrl());
					break;
				}
			}
			
//			System.out.println(driver.getCurrentUrl());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		

}
