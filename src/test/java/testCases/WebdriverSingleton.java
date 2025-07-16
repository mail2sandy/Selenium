package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebdriverSingleton {
	
	private static volatile WebdriverSingleton instance;
	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
	
	private WebdriverSingleton() {}
	
	private void initDriver(String browser) {
		switch(browser.toLowerCase()) {
		case "chrome" : tDriver.set(new ChromeDriver());break;
		case "edge" : tDriver.set(new EdgeDriver());break;
		case "default" : System.out.println("Invalid Browser Name");
		}
	}
	
	public static WebdriverSingleton getInstance(String browser) {
		if (instance == null) {
			synchronized (WebdriverSingleton.class) {
				if(instance == null) {
					instance = new WebdriverSingleton();
				}
			}
		}
		
		if(tDriver.get() == null) {
			instance.initDriver(browser);
		}
		
		return instance;
	}
	
	public WebDriver getDriver() {
		return tDriver.get();
	}
	
	public static void quitBrowser() {
		if(tDriver.get() != null) {
			tDriver.get().quit();
			tDriver.remove();
		}
	}

}
