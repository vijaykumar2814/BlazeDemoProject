package com.qa.blazedemo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.blazedemo.base.BaseTest;
import com.qa.blazedemo.constants.AppConstants;

public class HomePageTest extends BaseTest{
	
	
	
	@Test
	public void homePageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageHeaderTest() {
		String actHeader = homePage.getHomePageHeader();
		Assert.assertEquals(actHeader, AppConstants.HOME_PAGE_HEADER);
	}
	
	@Test
	public void findFlightsButtonExistsTest() {
		Assert.assertEquals(true, homePage.isFindFlightsButtonExists());
	}
	
	
	@Test
	public void selectDepartureCityTest() {
		boolean isDepCitySelected = homePage.selectDepartureCity();
		System.out.println("isDepCitySelected in TEst"+isDepCitySelected);
	}
	
	@Test
	public void selectDestinationCityTest() {
		boolean isDestCitySelected = homePage.selectDestinationCity();
		System.out.println("isDestCitySelected in TEst"+isDestCitySelected);
	}
	
	@Test(priority = Integer.MAX_VALUE)
	public void clickOnFindFlightsTest() {
		selectFlight = homePage.clickOnFindFlights();
		Assert.assertEquals(selectFlight.isChoseFlightPageHeaderDisplayed(), true);
	}
	
	
}
