package com.qa.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.blazedemo.utils.ElementUtil;
import com.qa.blazedemo.constants.AppConstants;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	Select select;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	By header_Welcome = By.xpath("//h1[contains(text(),'Welcom')]");
	By btn_FindFlights = By.xpath("//input[@type ='submit' and @value='Find Flights']");
	By link_home = By.xpath("//a[@href='home']");
	By dropDown_DepCity = By.name("fromPort");
	By dropDown_DestCity = By.name("toPort");
	
	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.HOME_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIMEOUT);
		System.out.println("Home page title: "+title);
		return title;
	}
	
	public String getHomePageHeader() {
		String header = eleUtil.doGetElementText(header_Welcome);
		System.out.println("Home page header: "+header);
		return header;
	}
	
	public  boolean isFindFlightsButtonExists() {
		boolean findFlightsButtonDispalyed =  eleUtil.isElementDisplayed(btn_FindFlights);
		System.out.println("Find flights button displayed..? "+findFlightsButtonDispalyed);
		return findFlightsButtonDispalyed;
	}
	
	public LoginPage clickOnHomeLink() {
		eleUtil.doClick(link_home);
		return new LoginPage(driver);
	}
	
	public boolean selectDepartureCity() {
		select = new Select(eleUtil.waitForElementVisible(dropDown_DepCity, AppConstants.DEFAULT_LONG_TIMEOUT));
		select.selectByVisibleText("Mexico City");
		WebElement depCitySelected = select.getFirstSelectedOption();
		if(depCitySelected.isSelected()) {
			System.out.println("Successfully selected the departure city "+depCitySelected.getText());
			return true;
		}
		
		else {
			return false;
		}
	}
	
	
	public boolean selectDestinationCity() {
		select = new Select(eleUtil.waitForElementVisible(dropDown_DestCity, AppConstants.DEFAULT_LONG_TIMEOUT));
		select.selectByVisibleText("Rome");
		WebElement destCitySelected = select.getFirstSelectedOption();
		if(destCitySelected.isSelected()) {
			System.out.println("Successfully selected the destination city "+destCitySelected.getText());
			return true;
		}
		
		else {
			return false;
		}
	}
		
	public SelectFlightPage clickOnFindFlights() {
		eleUtil.doClick(btn_FindFlights);
		return new SelectFlightPage(driver);
	}
	

}
