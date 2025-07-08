package testCases;

import org.testng.annotations.Test;

import pageObjects.ProductsPage;

public class TC005_WebScraping extends BaseClass{

	
	@Test
	public void scraping() {
		ProductsPage PP = new ProductsPage(driver);
		PP.clickProductLink();
		PP.webScrap();
	}
}
