package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.devtools.*;


public class BaseClass {
	public Logger log;
	WebDriver driver;
    private static ChromeDriver chromeDriver;
	public Properties prop;
	private static ThreadLocal <WebDriver> tdriver = new ThreadLocal<>();
    private static DevTools chromeDevTools;

	
	public void setDriver(WebDriver driver) {
		tdriver.set(driver);
		}
	
	public WebDriver getDriver() {
		return tdriver.get();
	}

	@BeforeClass (groups = {"smoke", "regression", "E2E", "dataDriven"})
	@Parameters({"os", "browser"})
	public void Setup(String os, String browser) throws IOException, InterruptedException {
		
		log = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		String urlToLoad = prop.getProperty("appUrl");
		
		
		switch(browser.toLowerCase()) {
		case "chrome" : chromeDriver= new ChromeDriver(); 
						chromeDevTools = chromeDriver.getDevTools();
				        chromeDevTools.createSession();
						setDriver(chromeDriver);
						break;
		case "edge" : driver= new EdgeDriver();setDriver(driver); break;
		case "default" : log.error("Invalid Browser Name"); return;
		}
		Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		WebDriverWait wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		// Wait until the login button is visible

		getDriver().manage().deleteAllCookies();
		log.info(prop.getProperty("appUrl"));
		getDriver().get("https://www.automationexercise.com/");
		getDriver().manage().window().maximize();
		log.info("Page launched sucessfully in " + browser);
		System.out.println("Page launched sucessfully in " + getDriver().getTitle());
		
	}
	
	public String takeScreenShot(String name) {
		
		String timeStamp = new SimpleDateFormat("yyyyddmmss").format(new Date());
		
		File sourceFile = ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")+"//screenshots//"+name+timeStamp+".png";
		
		File targetFile = new File(path);
		
		sourceFile.renameTo(targetFile);
		
		return path;
		
	}
	
	@AfterClass(groups = {"smoke", "regression", "E2E", "dataDriven"})
	public void shutDown() {
		getDriver().quit();
		tdriver.remove();
	}
	


}
