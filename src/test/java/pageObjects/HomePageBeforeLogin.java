package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageBeforeLogin extends BasePage{
	
	public HomePageBeforeLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//ul[contains(@class, 'navbar-nav')]//a[text()=' Home']") WebElement homeLink;
	@FindBy(xpath="//ul[contains(@class, 'navbar-nav')]//a[text()=' Products']") WebElement ProductsLink;
	
	public boolean homeLinkExistCheck() {
		try {
		return homeLink.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean productLinkExistCheck() {
		try {
		return ProductsLink.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}

}
