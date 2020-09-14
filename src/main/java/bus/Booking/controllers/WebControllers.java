package bus.Booking.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebControllers {
	
	WebDriver browserLaunch();
	void maximizeBrowser();
	void getUrl();
	void closeBrowser();
	void implictWait();
	void waitforElementClickable(WebElement element);
	void scrollBottom();
}
