package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAfterLogin extends BasePage{
	
	public HomePageAfterLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//ul[contains(@class, 'navbar-nav')]//a[text()=' Logout']") WebElement logout;
	
	public boolean logOutLinkExistCheck() {
		try {
			wait.until(d -> logout.isDisplayed());

			return logout.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}

}
