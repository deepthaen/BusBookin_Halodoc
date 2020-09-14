package bus.Booking.implementions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bus.Booking.controllers.BrowserUtil;
import bus.Booking.controllers.WebControllers;
import bus.Booking.utils.PropertyFiles;

public class WebImplemention implements WebControllers{
	
	public WebDriver driver;
	public WebImplemention(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver browserLaunch() {
		this.driver = BrowserUtil.getInstance();
		return driver;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
		System.out.println("Maximize Browser");
		
	}

	public void implictWait() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}

	public void getUrl() {
		String url = PropertyFiles.getProperty_Value("Url");
		driver.get(url);
		System.out.println("Url ::" + url);
	}

	public void closeBrowser() {
		
		driver.quit();
		System.out.println("Close Browser");
	
	}
	
	public void waitforElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollBottom() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,1000)");
	 }
	
}
