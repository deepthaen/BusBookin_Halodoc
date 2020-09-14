package bus.Booking.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bus.Booking.implementions.WebImplemention;

public class HomePage extends WebImplemention{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDepartDate']")
	public WebElement calender;
	
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement nextArrow;
	
	@FindBy(xpath = "//a[contains(text(),'21')]")
	public WebElement selectDate;
	
	@FindBy(xpath = "//input[@id='txtOrigin']")
	public WebElement selectOrigin;
	
	@FindBy(xpath = "//ul[@class='select2-results']/li/ul/li")
	public WebElement originCity;
	
	@FindBy(xpath = "//input[@id='txtDestination']")
	public WebElement selectDestination;
	
	@FindBy(xpath = "(//ul[@class='select2-results'])[2]/li/ul/li")
	public WebElement destinationCity;
	
	@FindBy(xpath = "//input[@id='btnBusSearchNew']")
	public WebElement bookNow;
	
	
	public void selectDate_calender() {
		waitforElementClickable(calender);
		calender.click();
		nextArrow.click();
		selectDate.click();
	}
	
	public void selectOrigin_Place() {
		waitforElementClickable(selectOrigin);
		
		selectOrigin.click();
		System.out.println("Selecting Origin City ::" + originCity.getText());
		originCity.click();
	}
	
	public void selectDestination_Place() {
		waitforElementClickable(selectDestination);
		
		selectDestination.click();
		System.out.println("Selecting destination city :: "+destinationCity.getText());
		destinationCity.click();
	}
	
	public void booknow() {
		waitforElementClickable(bookNow);
	   bookNow.click();	
	   System.out.println("Clicking on Book Now");
	}

}
