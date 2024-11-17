package com.qa.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.blazedemo.constants.AppConstants;
import com.qa.blazedemo.utils.ElementUtil;

public class RegisterUserSuccessPage {
	WebDriver driver;
	ElementUtil eleUtil;

	public RegisterUserSuccessPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By txtError_RegisteredUser = By.cssSelector("div.message");
	
	public boolean verifyUserIsCreated() {
		String userRegisterMessaage= eleUtil.waitForElementVisible(txtError_RegisteredUser, AppConstants.DEFAULT_LONG_TIMEOUT).getText();
		System.out.println("Message shown after Registering the user "+userRegisterMessaage);
		if(userRegisterMessaage.contains("Page Expired")) {
			System.out.println("There is an application error found  while registering the user. Please connect  with Dev team");
			return  true;
		}
		else {
			return false;
		}
	}

	
}
