package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageBeforeLogin;

public class TC002_HomePageValidation extends BaseClass{

	@Test (groups={"smoke", "E2E"})
	public void homePageValidation() {
		log.info("**************TC002_HomePageValidation Started**************");

		HomePageBeforeLogin HP = new HomePageBeforeLogin(getDriver());
		Assert.assertEquals(true, HP.homeLinkExistCheck());
		Assert.assertEquals(true, HP.productLinkExistCheck());
		log.info("**************TC002_HomePageValidation Ended**************");

	}
	
}
