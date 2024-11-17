package com.qa.blazedemo.utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String waitForURLContainsAndReturn(String URL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(URL));// true
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			System.out.println("URL is not matched");
			return "-1";
		}

	}
	
	public String waitForTitleContainsAndReturn(String fractionTitle, int timeOut) {
		System.out.println("Inside  eleutil method waitForTitleContainsAndReturn");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			
			wait.until(ExpectedConditions.titleContains(fractionTitle));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println("title is not matched");
			return "-1";
		}
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed : " + locator);
			return false;
		}
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void doSendKeys(By locator, String value, int timeOut) {
		waitForElementVisible(locator, timeOut).sendKeys(value);
	}
	
	public String doGetElementText(By locator) {
		String eleText = getElement(locator).getText();
		if (eleText != null) {
			return eleText;
		} else {
			System.out.println("Element text is null:" + eleText);
			return null;
		}
	}
	
	public void selectDropDownValueByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
