package com.qa.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.blazedemo.constants.AppConstants;
import com.qa.blazedemo.utils.ElementUtil;

public class RegisterPage {
	
		WebDriver driver;
		ElementUtil eleUtil;

		public RegisterPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
		
		By btn_Register = By.xpath("//button[@type='submit' and contains(text(),'Register')]"); 
		By input_Name = By.cssSelector("input#name");
		By input_Company = By.cssSelector("input#company");
		By input_Email = By.cssSelector("input#email");
		By input_Password = By.cssSelector("input#password");
		By input_ConfirmPassword = By.cssSelector("input#password-confirm");
		
		
		public boolean isRegisterLinkExists() {
			return eleUtil.isElementDisplayed(btn_Register);
		}
		
		public String getRegisterPageUrl() {
			String registerPageUrl = eleUtil.waitForURLContainsAndReturn(AppConstants.REGISTER_PAGE_URL, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
			System.out.println("Register Page url "+registerPageUrl);
			return registerPageUrl;
		}
		
		public RegisterUserSuccessPage userRegistration(String firstName, String company, String email, String password) {
				
			eleUtil.waitForElementVisible(this.input_Name, AppConstants.DEFAULT_SHORT_TIMEOUT).sendKeys(firstName);
			eleUtil.waitForElementVisible(this.input_Company, AppConstants.DEFAULT_SHORT_TIMEOUT).sendKeys(company);
			eleUtil.waitForElementVisible(this.input_Email, AppConstants.DEFAULT_SHORT_TIMEOUT).sendKeys(email);
			eleUtil.waitForElementVisible(this.input_Password, AppConstants.DEFAULT_SHORT_TIMEOUT).sendKeys(password);
			eleUtil.waitForElementVisible(this.input_ConfirmPassword, AppConstants.DEFAULT_SHORT_TIMEOUT).sendKeys(password);
			eleUtil.waitForElementVisible(btn_Register, AppConstants.DEFAULT_SHORT_TIMEOUT).click();
			return new RegisterUserSuccessPage(driver);
			
			
			
		}
		
}
