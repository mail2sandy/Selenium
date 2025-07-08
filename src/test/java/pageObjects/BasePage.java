package pageObjects;

import java.time.Duration;

import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	Wait <WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public BasePage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
}
