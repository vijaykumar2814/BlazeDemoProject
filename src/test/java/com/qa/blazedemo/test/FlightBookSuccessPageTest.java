package com.qa.blazedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.blazedemo.base.BaseTest;
import com.qa.blazedemo.constants.AppConstants;

public class FlightBookSuccessPageTest extends BaseTest{
	
	@BeforeClass()
	public void flightBookSuccessPageSetUp() {
		selectFlight = homePage.clickOnFindFlights();
		userDetailsPage = selectFlight.selectFlight();
	}
	
	
	@DataProvider
	public Object[][] userDetailsToBookFlight_11() {
		return new Object[][] {
			{"Vijay_Newww", "ProvstBentzonsVej_1", "Copenhagen", "Denmark", "2300", "1234567812345678", "10", "2012", "Vijayakumar"},
		};
	}
	
	
	@Test(priority = Integer.MAX_VALUE, dataProvider = "userDetailsToBookFlight_11")
	public void flightPurchaseTest(String name, String address, String city, String state, String zipCode, String creditCardNumber, String month,String year, String nameOnCard) {
		flightBookSuccessPage = userDetailsPage.enterUserdetailsForBooking(name, address, city, state, zipCode, creditCardNumber, month, year, nameOnCard);
		Assert.assertEquals(flightBookSuccessPage.verifySuccessMessage(), AppConstants.FLIGHT_TICKET_BOOK_SUCCESSMESSAGE);
		
	}
	
	public void enteruserDetailsAndPurchaseFlightTicket(String name, String address, String city, String state, String zipCode, String creditCardNumber, String month,String year, String nameOnCard) {
		flightBookSuccessPage = userDetailsPage.enterUserdetailsForBooking(name, address, city, state, zipCode, creditCardNumber, month, year, nameOnCard);
		Assert.assertEquals(flightBookSuccessPage.verifySuccessMessage(), AppConstants.FLIGHT_TICKET_BOOK_SUCCESSMESSAGE);
	
	}
	
}
