package com.qa.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.blazedemo.constants.AppConstants;
import com.qa.blazedemo.utils.ElementUtil;

public class LoginPage {
	WebDriver driver;
	ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By btn_Login = By.xpath("//button[@type='submit' and contains(text(),'in')]");
	By link_ForgotPassword = By.xpath("//a[contains(@href,'reset') and contains(text(),'Forgot')]");
	By link_Register = By.xpath("//a[contains(@href,'register') and contains(text(),'Register')]");
	
	public String getLoginPageUrl() {
		String loginPageUrl = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_URL, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		System.out.println("Login Page Url: "+loginPageUrl);
		return loginPageUrl;
	}
	
	public boolean isLoginButtonExists() {
		return eleUtil.isElementDisplayed(btn_Login);
	}
	
	public boolean isForgotPasswordExists() {
		System.out.println("ForgotPassword Link displayed .. ? "+eleUtil.isElementDisplayed(link_ForgotPassword));
		return eleUtil.isElementDisplayed(link_ForgotPassword);
		 
	}
	
	public boolean isRegisterLinksExists() {
		System.out.println("Register Link displayed .. ? "+eleUtil.isElementDisplayed(link_Register));
		return eleUtil.isElementDisplayed(link_Register);
		
	}
	
	public RegisterPage clickOnRegisterLink() {
		eleUtil.waitForElementVisible(link_Register, AppConstants.DEFAULT_MEDIUM_TIMEOUT).click();
		return new RegisterPage(driver);
	}
	
	
}
