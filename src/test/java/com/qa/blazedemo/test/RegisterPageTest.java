package com.qa.blazedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.blazedemo.base.BaseTest;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void registerPageSetup() {
		loginPage = homePage.clickOnHomeLink();
		registerPage = loginPage.clickOnRegisterLink();
	}
	
	@DataProvider
	public Object[][] enterUserDataForRegistration() {
		return new Object[][] {
			{"Testuser1", "amazon", "test@amazon.com", "test@123"},
		};
	}
	
	
	@Test(dataProvider = "enterUserDataForRegistration")
	public  void userRegistrationTest(String firstName, String company, String email, String password) {
		registerUserSuccessPage = registerPage.userRegistration(firstName, company, email, password);
		Assert.assertEquals(registerUserSuccessPage.verifyUserIsCreated(), true);
	
	}
	
	
	

}
