package bus.Booking.webPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bus.Booking.configuration.Constants;
import bus.Booking.implementions.WebImplemention;
import bus.Booking.utils.PropertyFiles;

public class PaymentPages extends WebImplemention{
	
	public PaymentPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtName']")
	public WebElement name;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPhone']")
	public WebElement phonenumber;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEmail']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEmail1']")
	public WebElement ReEmail;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnProceedPayment']")
	public WebElement ProceedPayment;
	
	public String userName() {
		String Uname = PropertyFiles.getProperty_Value(Constants.USERNAME);
		System.out.println("UserName :" + Uname);
		return Uname;
	}
	
	public String phoneNumber() {
		String phoneNumber = PropertyFiles.getProperty_Value(Constants.PHONENUMBEER);
		System.out.println("PhoneNumber :" + phoneNumber);
		return phoneNumber;
	}
	
	public String email() {
		String UEmail = PropertyFiles.getProperty_Value(Constants.EMAIL);
		System.out.println("email id :" + UEmail);
		return UEmail;
	}
	
	public String reEmailId() {
		String UReEmailid = PropertyFiles.getProperty_Value(Constants.RE_EMAIL);
		System.out.println("ReEmail id  :" + UReEmailid);
		return UReEmailid;
	}
	
	public void personalDetails() {
		waitforElementClickable(name);
		name.sendKeys(userName());
		phonenumber.sendKeys(phoneNumber());
		email.sendKeys(email());
		ReEmail.sendKeys(reEmailId());
	}
	 
	
	 public void paymentClick() {
		 waitforElementClickable(ProceedPayment);
		 ProceedPayment.click();
		 System.out.println("Clicking on proceed Payment");
	 }
	 
	 public void verifyText() {
		 String execptedText = "Please select a payment method";
		 String actualtext= driver.switchTo().alert().getText();
		 System.out.println("Verified Text ::" + actualtext);
		 Assert.assertEquals(actualtext, execptedText);
		 driver.switchTo().alert().accept();
	 }
}
