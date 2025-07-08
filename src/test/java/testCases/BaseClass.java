package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Logger log;
	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	@Parameters({"os", "browser"})
	public void Setup(String os, String browser) throws IOException, InterruptedException {
		log = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		String urlToLoad = prop.getProperty("appUrl");
		
		
		switch(browser.toLowerCase()) {
		case "chrome" : driver= new ChromeDriver(); break;
		case "edge" : driver= new EdgeDriver(); break;
		case "default" : log.error("Invalid Browser Name"); return;
		}
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		log.info(prop.getProperty("appUrl"));
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		log.info("Page launched sucessfully in " + browser);
		
	}
	
	@AfterClass
	public void shutDown() {
		driver.quit();
	}
	


}
