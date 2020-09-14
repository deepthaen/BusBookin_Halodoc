package bus.Booking.webPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import bus.Booking.implementions.WebImplemention;

public class BusDetailsPage extends WebImplemention{

	

	public BusDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath  = "//input[@class='seatproceed']")
	public WebElement proceed;

	@FindBys(@FindBy(xpath="//div[@class='busprice1']"))
	public List<WebElement> busPrices;

	public void selectMinPrice_bus() {
		
		int price = busPrices.size();//9
		double up = 0;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String pricetext = driver.findElement(By.xpath("(//div[@class='busprice1'])[1]")).getText();
		pricetext =  pricetext.replace("RM ", "");
		double dp =  Double.parseDouble(pricetext);
		for (int i = 2; i <=price; i++) {
			waitforElementClickable(driver.findElement(By.xpath("(//div[@class='busprice1'])["+i+"]")));
			String priceval = driver.findElement(By.xpath("(//div[@class='busprice1'])["+i+"]")).getText();
			priceval =  priceval.replace("RM ", "");
			double d =  Double.parseDouble(priceval);
			if(dp<=d) {//35.40<=22.00
				up=dp;//22.40
			}else {
				up=d; //up = 22.40
				dp=d; //dp =22.40
			}
		}
		System.out.println(up);
		
		driver.findElement(By.xpath("//div[contains(text(),'"+String.valueOf(up)+"')]/../../../td[6]/a")).click();

	}

	public void selectSeat() {
		int seatsize = driver.findElements(By.xpath("//table[@class='seat_panel1']/tbody/tr[1]/td")).size();
		System.out.println(seatsize);
		int r=1;
		boolean flag =true;
		int number =6;
		int count =0;
		while(flag) {
			for (int i = 2; i <=seatsize; i++) {
				String path ="//table[@class='seat_panel1']/tbody/tr["+r+"]/td["+i+"]//div[@class='seat_available']";
				int seat = driver.findElements(By.xpath(path)).size();
				if(seat>0) {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.xpath(path)).click();
					count++;
				}
				if(number == count) {
					flag = false;
					break;
				}
			}

			r++;
		}


	}

	public void clickOn_proceed() {
		waitforElementClickable(proceed);
		proceed.click();
		
	}


}
