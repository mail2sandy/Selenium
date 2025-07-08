package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	@FindBy(xpath="(//div[@class='login-form']//h2/b)[1]") WebElement registrationPage;
	
	public String registrationPageConfirmation() {
		try {
		return registrationPage.getText();
		} catch (Exception e) {
		return e.getMessage();	
		}
	}
}
