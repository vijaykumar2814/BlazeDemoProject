package com.qa.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.blazedemo.constants.AppConstants;
import com.qa.blazedemo.utils.ElementUtil;

public class FlightBookSuccessPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	Select select;

	public FlightBookSuccessPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	By txt_successMessage = By.xpath("//h1[contains(text(),'Thank you')]");
	By flightBooking_Id = By.xpath("//tbody//td[contains(text(),'Id')]/following-sibling::td");
	By flightBooking_Date = By.xpath("//tbody//td[contains(text(),'Date')]/following-sibling::td");
	
	public String verifySuccessMessage() {
		String successMessage = eleUtil.waitForElementVisible(txt_successMessage, AppConstants.DEFAULT_LONG_TIMEOUT).getText();
		System.out.println("Flight is booked and booking success message shown ::"+successMessage);
		
		verifyBookingIdAndDate();
		
		return successMessage;
	}
	
	public boolean verifyBookingIdAndDate() {
		String bookingID = eleUtil.waitForElementVisible(flightBooking_Id, AppConstants.DEFAULT_LONG_TIMEOUT).getText();
		String bookingDate = eleUtil.waitForElementVisible(flightBooking_Date, AppConstants.DEFAULT_LONG_TIMEOUT).getText();
		String bookingIdAndDate = "BookingID: "+bookingID.concat("\nBooking Date : "+bookingDate);
		System.out.println("Booking details are ::\n"+bookingIdAndDate);
		if(!bookingIdAndDate.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}
