package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		 
	}

	@FindBy(xpath="//a[@href='/login']") WebElement signUplink;
	@FindBy(xpath="//input[@data-qa='signup-name']") WebElement txtUserName;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement txtEmailID;
	@FindBy(xpath="//button[@data-qa='signup-button']") WebElement btnSubmit;
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement loginEmail;
	@FindBy(xpath="//input[@data-qa='login-password']") WebElement loginPassword;
	@FindBy(xpath="//button[@data-qa='login-button']") WebElement signIn;
	@FindBy(xpath="//ul[contains(@class, 'navbar-nav')]//a[text()=' Logout']") WebElement logOut;


	public void signUplinkClick(){
		signUplink.click();
	}
	
	public void userName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	public void userEmail(String userEmail) {
		txtEmailID.sendKeys(userEmail);
	}
	
	public void submit() {
		btnSubmit.click();
	}
	
	public void loginEmail(String userName) {
		loginEmail.sendKeys(userName);
	}
	
	public void loginPassword(String pwd) {
		loginPassword.sendKeys(pwd);
	}
	
	public void signIn() {
		signIn.click();
	}
	
	public boolean logOut() {
		try {
			wait.until(d -> logOut.isDisplayed());
			return logOut.isDisplayed();
		
		}catch (Exception e)
		{
			return false;
		}
	}
	
	public void logOutClick() {
		try {
			wait.until(d -> logOut.isDisplayed());
			logOut.click();
		
		}catch (Exception e)
		{
			Assert.fail();
		}
	}
	
}
