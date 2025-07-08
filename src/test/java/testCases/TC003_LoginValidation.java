package testCases;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageAfterLogin;
import pageObjects.HomePageBeforeLogin;
import pageObjects.SignUpPage;

public class TC003_LoginValidation extends BaseClass{
	
	@Test
	public void loginCheck() {
		log.info("************************TC003_loginValidation Started*********************");
		
		SignUpPage SUP = new SignUpPage(driver);
		SUP.signUplinkClick();
		SUP.loginEmail(prop.getProperty("loginUser"));
		SUP.loginPassword(prop.getProperty("loginPassword"));
		SUP.signIn();
		HomePageAfterLogin AUL = new HomePageAfterLogin(driver);

		Assert.assertEquals(true, AUL.logOutLinkExistCheck());
		log.info("************************TC003_loginValidation Ended*********************");

	}

}
