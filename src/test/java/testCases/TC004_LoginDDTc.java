package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageAfterLogin;
import pageObjects.SignUpPage;
import utilities.DataProviders;

public class TC004_LoginDDTc extends BaseClass{
	
	@Test (dataProvider="loginData", dataProviderClass=DataProviders.class, groups={"dataDriven", "E2E"})
	public void logincheck(String userId, String password, String type){
		log.info("*****************TC004_LoginDDTc Started*********************");
		try {
		
		
		SignUpPage SUP = new SignUpPage(driver);
		SUP.signUplinkClick();
		SUP.loginEmail(userId);
		SUP.loginPassword(password);
		SUP.signIn();
		
		HomePageAfterLogin HPAL = new HomePageAfterLogin(driver);
		Boolean test = HPAL.logOutLinkExistCheck();
		
		if(type.equalsIgnoreCase("valid")) {
			Assert.assertEquals(true, test);
			SUP.logOutClick();
		}else {
			Assert.assertEquals(false, test);
		}
		}catch (Exception e) {
			log.error(e.getMessage());
			Assert.fail();
		}
		log.info("*****************TC004_LoginDDTc Ended*********************");

	}

}
