package com.qa.blazedemo.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.blazedemo.exceptions.BrowserException;
import com.qa.blazedmo.errors.AppError;



public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the driver on the browsername
	 * @param Properties class to get  browsername
	 * @return it returns driver
	 */
	
	public WebDriver initDriver(Properties prop) {
		
		String browsername = prop.getProperty("browser");
		System.out.println("browser name is : "+browsername);
	
		switch (browsername.toLowerCase().trim()) {
		case "chrome": 
			tlDriver.set(new ChromeDriver());
			System.out.println("Running with thread  loacal driver ");
			break;
			
		case "firefox": 
			tlDriver.set(new FirefoxDriver());
			break;
			
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
		
		case "safari": 
			tlDriver.set(new SafariDriver());
			break;
		
		default:
			System.out.println(AppError.INAVALID_BROWSER_MSG +browsername+ " is invalid");
			throw new BrowserException(AppError.INAVALID_BROWSER_MSG);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is used to init the properties from the config file
	 * @return It returns prop reference
	 */
	public Properties initProp() {
		prop = new Properties(); 
		FileInputStream fis=null;
		String envName = System.getProperty("env");
		System.out.println("running test on env "+envName);
		try {
		if(envName==null) {
			System.out.println("env is null and hence running test in qa env");
			fis = new FileInputStream("./src/test/resources/config/qa.config.properties");
			
		}
		else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				System.out.println("running on QA environment");
				fis = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "dev":
				System.out.println("running on Dev environment");
				fis = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
			case "uat":
				System.out.println("running on UAT environment");
				fis = new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;
			case "prod":
				System.out.println("running on Prod environment");
				fis = new FileInputStream("./src/test/resources/config/config.properties");
				break;

			default:
				System.out.println("Please pass right enviroment");
				break;
			}
		}
		
		prop.load(fis);
		} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		
		return prop;
		
	}

}
