package com.qa.blazedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.blazedemo.base.BaseTest;
import com.qa.blazedemo.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.clickOnHomeLink();
	}
	
	@Test
	public void loginButtonExistsTest() {
		boolean isLoginButtonDisplayed = loginPage.isLoginButtonExists();
		Assert.assertEquals(isLoginButtonDisplayed, true);
	}
	
	@Test
	public void forgotPasswordLinkTest() {
		boolean isForgotPasswordLinkPresent = loginPage.isForgotPasswordExists();
		Assert.assertEquals(isForgotPasswordLinkPresent, true);
	}
	
	@Test
	public void registerLinkExistsTest() {
		boolean isRegisterLinkPresent = loginPage.isRegisterLinksExists();
		Assert.assertEquals(isRegisterLinkPresent, true);
	}
	
	@Test(priority=Integer.MAX_VALUE)
	public void clickOnRegisterLinkTest() {
		registerPage = loginPage.clickOnRegisterLink();
		Assert.assertEquals(registerPage.getRegisterPageUrl(), AppConstants.REGISTER_PAGE_URL);
	}
	
	
	
}
