package bus.Booking.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtil {
	
	public static WebDriver driver;
	
	public BrowserUtil() {
		if(driver == null) {
			this.driver = getInstance();
		}
	}
	
	public static WebDriver getInstance() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL-E7470\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
		driver = new ChromeDriver(capabilities());
		System.out.println("Launching Browser");
		return driver;
	}

	
	public static ChromeOptions capabilities() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}
}
