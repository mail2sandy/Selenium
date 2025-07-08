package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.RegistrationPage;
import pageObjects.SignUpPage;


public class TC001_SignUpValidation extends BaseClass{
	
	@SuppressWarnings("deprecation")
	@Test
	public void signUpValidation() {
		log.info("**************TC001_SignUpValidation Started**************");
		Faker fackData = new Faker();
		
		SignUpPage SUP = new SignUpPage(driver);
		SUP.signUplinkClick();
		log.info("signUplinkClick sucessfully selected");
//		SUP.userName(RandomStringUtils.randomAlphabetic(5));
		SUP.userName(prop.getProperty("appUrl"));
		SUP.userEmail(fackData.name().firstName()+"@gmail1.com");
		SUP.submit();
		log.info("submit sucessfully selected");
		log.debug("Sucess");
		RegistrationPage RP = new RegistrationPage(driver);
		Assert.assertEquals( RP.registrationPageConfirmation().trim(),"ENTER ACCOUNT INFORMATION");
		log.info("**************TC001_SignUpValidation Ended**************");

	}

}
