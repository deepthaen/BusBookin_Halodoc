package bus.Booking;

import org.testng.annotations.Test;

import bus.Booking.controllers.BaseTest;
import bus.Booking.webPages.BusDetailsPage;
import bus.Booking.webPages.HomePage;
import bus.Booking.webPages.PaymentPages;

public class EndtoEnd_BusBooking extends BaseTest {

	HomePage homePage;
	PaymentPages paymentPage;
	BusDetailsPage detailsPage;
	
	@Test
	public void bookBusSeats_HappyFlow() {
		
		homePage = new HomePage(driver);
		paymentPage = new PaymentPages(driver);
		detailsPage = new BusDetailsPage(driver);
		
		homePage.selectDate_calender();
		homePage.selectOrigin_Place();
		homePage.selectDestination_Place();
		homePage.booknow();
		
		detailsPage.selectMinPrice_bus();
		detailsPage.selectSeat();
		detailsPage.clickOn_proceed();
		
		paymentPage.personalDetails();
		paymentPage.paymentClick();
		paymentPage.verifyText();
	}
	
}
