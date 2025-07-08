package pageObjects;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{
    public JSONArray scrapedData = new JSONArray();

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//ul[contains(@class, 'navbar-nav')]//a[text()=' Products']") WebElement ProductsLink;

	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']") WebElement productsList;
	
	public void webScrap() {
		List<WebElement> productLists = productsList.findElements(By.xpath("//div[@class='productinfo text-center']"));
		
//		for(int i = 0; i<=productLists.size();i++) {
//			productLists.get(i).findElement(By.xpath(".//img")).getAttribute("src");
//		}
		
		for (WebElement list : productLists) {
			String image = list.findElement(By.xpath(".//img")).getAttribute("src");
			String price = list.findElement(By.xpath(".//h2")).getText();
			String name = list.findElement(By.xpath(".//p")).getText();
			JSONObject prodDetails = new JSONObject();

			prodDetails.put("Image", image);
			prodDetails.put("Name", name);
			prodDetails.put("Price", price);
			scrapedData.put(prodDetails);
		}
		
		System.out.println(scrapedData.toString(1));
		
	}
	
	public void clickProductLink() {
		ProductsLink.click();
	}
	
	
}
