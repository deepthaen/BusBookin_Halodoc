package bus.Booking.controllers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import bus.Booking.implementions.WebImplemention;

public class BaseTest {
	public WebDriver driver;
	
	public WebControllers webControler;
	
	@BeforeMethod
	public void tearUp() {
		webControler = new WebImplemention(driver);
		this.driver = webControler.browserLaunch();
		webControler.implictWait();
		webControler.maximizeBrowser();
		webControler.getUrl();
	}
	
	@AfterMethod
	public void tearDown() {
		webControler = new WebImplemention(driver);
		webControler.closeBrowser();
	}

}
