package com.qa.blazedemo.pages;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.blazedemo.constants.AppConstants;
import com.qa.blazedemo.utils.ElementUtil;

public class SelectFlightPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	Select select;

	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By header_selectFlight = By.xpath("//h3[contains(text(),'Flights from')]");
	By list_Flights= By.xpath("//table//tbody/tr//input[@type='submit']");
//	By header_flightReserved;
	By input_name = By.id("inputName");
	By input_address = By.id("address");
	By input_city = By.id("address");
	By input_state = By.id("address");
	By input_zipCode = By.id("address");
	By dropDown_cardType = By.xpath("//select[@id='cardType']");
	By input_CreditCardNumber = By.id("creditCardNumber");
	By input_Month = By.id("creditCardMonth");
	By input_Year = By.id("creditCardYear");
	By input_nameOnCard = By.id("nameOnCard");
	
	
	public boolean isChoseFlightPageHeaderDisplayed() {
		return eleUtil.waitForElementVisible(header_selectFlight, AppConstants.DEFAULT_LONG_TIMEOUT).isDisplayed();
	}
	
	public UserDetailsPage selectFlight() {
		System.out.println("inside select flight");
		eleUtil.waitForElementVisible(list_Flights, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		List<WebElement> availableFlights = eleUtil.getElements(list_Flights);
		int totalFlights = availableFlights.size();
		Random random = new Random();
		int randomFlightSelected =random.nextInt(totalFlights);
		System.out.println("randomFlightSelected option "+randomFlightSelected);
		availableFlights.get(randomFlightSelected).click();
		return new UserDetailsPage(driver);
	}
	
}
