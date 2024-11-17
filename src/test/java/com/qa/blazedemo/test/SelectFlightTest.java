package com.qa.blazedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.blazedemo.base.BaseTest;

public class SelectFlightTest extends BaseTest{
	
	@BeforeClass
	public void registerPageSetup() {
		selectFlight = homePage.clickOnFindFlights();
	}
	
	@Test
	public void isFlightPageHeaderDisplayed() {
		Assert.assertEquals(selectFlight.isChoseFlightPageHeaderDisplayed(), true);;
	
	}

	@Test
	public void selectFlightTest() {
		userDetailsPage = selectFlight.selectFlight();
		Assert.assertEquals(userDetailsPage.isUserDetailsPageHeaderDisplayed(), true);
	}
	
}
