package testCases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.*;

public class TC015_MouseAction extends BaseClass{
	@Test(priority=0)
	public void mouseHover() throws InterruptedException {
		
		WebElement firstItem = getDriver().findElement(By.xpath("(//div[@class='single-products'])[1]"));
		WebElement firstItemAddtoCart = getDriver().findElement(By.xpath("(//div[@class='product-overlay'])[1]//a[text()='Add to cart']"));
		WebElement confirmation = getDriver().findElement(By.xpath("//div[@class='modal-content']//div[@class='modal-header']"));
		
		JavascriptExecutor jsRun = (JavascriptExecutor)getDriver();
		
		jsRun.executeScript("window.scrollBy(0, 450)", "");		
		
		Actions act = new Actions(getDriver());
		
		act.moveToElement(firstItem).build().perform();
		Thread.sleep(2000);
		// Wait until the login button is visible

		act.moveToElement(firstItemAddtoCart).click().build().perform();
		
		Thread.sleep(2000);

		
		Assert.assertEquals("Added", confirmation.getAttribute("innerText").replaceAll("[^a-zA-Z0-9 ]", ""));
		
		
	}
	
	@Test(priority=1)
	public void mouseDragAndDrop() throws InterruptedException {
		getDriver().get("https://demo.automationtesting.in/Static.html");
		WebElement dragAngular = getDriver().findElement(By.xpath("//div[@id='dragarea']//img[@id='angular']"));
		WebElement dragMongo = getDriver().findElement(By.xpath("//div[@id='dragarea']//img[@id='mongo']"));
		WebElement dragNode = getDriver().findElement(By.xpath("//div[@id='dragarea']//img[@id='node']"));
		
		WebElement dragTo = getDriver().findElement(By.xpath("//div[@id='droparea']"));
		
		
		Actions act = new Actions(getDriver());
		
		act.dragAndDrop(dragAngular, dragTo).perform();
		act.dragAndDrop(dragMongo, dragTo).perform();
		act.dragAndDrop(dragNode, dragTo).perform();
		
		File src = dragTo.getScreenshotAs(OutputType.FILE);
	    File dest = new File(System.getProperty("user.dir") +    "/screenshots/dragAnddrop.png");
	    
	    try {
	    	FileHandler.copy(src, dest);
	    } catch (IOException exception) {
	    	exception.printStackTrace();
	    }
	    
	    takeScreenShot("ValidateDragedItem");
	}
	
}
