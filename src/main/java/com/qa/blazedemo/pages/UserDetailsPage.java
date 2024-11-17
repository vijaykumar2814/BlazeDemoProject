package com.qa.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.blazedemo.constants.AppConstants;
import com.qa.blazedemo.utils.ElementUtil;

public class UserDetailsPage {
	WebDriver driver;
	ElementUtil eleUtil;

	public UserDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By header_userDetailsPage = By.xpath("//h2[contains(text(),'reserved')]");
	By input_name = By.id("inputName");
	By input_address = By.id("address");
	By input_city = By.id("city");
	By input_state = By.id("state");
	By input_zipCode = By.id("zipCode");
	By dropDown_cardType = By.xpath("//select[@id='cardType']");
	By input_CreditCardNumber = By.id("creditCardNumber");
	By input_Month = By.id("creditCardMonth");
	By input_Year = By.id("creditCardYear");
	By input_nameOnCard = By.id("nameOnCard");
	By btn_purchaseFlightTicket = By.xpath("//input[@type='submit']");
	
	public boolean isUserDetailsPageHeaderDisplayed() {
		boolean isHeaderDisplayed = eleUtil.waitForElementVisible(header_userDetailsPage, AppConstants.DEFAULT_LONG_TIMEOUT).isDisplayed();
		System.out.println("isHeaderDisplayed "+isHeaderDisplayed);
		return isHeaderDisplayed;
		
	}
	
	public FlightBookSuccessPage enterUserdetailsForBooking(String name, String address, String city, String state, String zipCode, String creditCardNumber, String month,String year, String nameOnCard) {
		eleUtil.waitForElementVisible(this.input_name, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(name);
		eleUtil.waitForElementVisible(this.input_address, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(address);
		eleUtil.waitForElementVisible(this.input_city, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(city);
		eleUtil.waitForElementVisible(this.input_state, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(state);
		eleUtil.waitForElementVisible(this.input_zipCode, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(zipCode);
		eleUtil.waitForElementVisible(this.input_CreditCardNumber, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(creditCardNumber);
		eleUtil.waitForElementVisible(this.input_Month, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(month);
		eleUtil.waitForElementVisible(this.input_Year, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(year);
		eleUtil.waitForElementVisible(this.input_nameOnCard, AppConstants.DEFAULT_LONG_TIMEOUT).sendKeys(nameOnCard);
		eleUtil.doClick(btn_purchaseFlightTicket);
		return  new FlightBookSuccessPage(driver);
		
	}

}
