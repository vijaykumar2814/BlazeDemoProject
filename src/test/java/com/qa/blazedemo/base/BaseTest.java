package com.qa.blazedemo.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.qa.blazedemo.factory.DriverFactory;
import com.qa.blazedemo.pages.FlightBookSuccessPage;
import com.qa.blazedemo.pages.HomePage;
import com.qa.blazedemo.pages.LoginPage;
import com.qa.blazedemo.pages.RegisterPage;
import com.qa.blazedemo.pages.RegisterUserSuccessPage;
import com.qa.blazedemo.pages.SelectFlightPage;
import com.qa.blazedemo.pages.UserDetailsPage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected RegisterPage registerPage;
	protected SelectFlightPage selectFlight;
	protected UserDetailsPage userDetailsPage;
	protected FlightBookSuccessPage flightBookSuccessPage;
	protected RegisterUserSuccessPage registerUserSuccessPage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(@Optional("chrome")String browserName) {
		System.out.println("browser from testng "+browserName);
		df = new DriverFactory();
		prop = df.initProp(); 
		
		/* to take browser value from testng.xml file */
		if(browserName!=null) {
			System.out.println("if not  equal to null "+browserName);
			prop.setProperty("browser", browserName);
		}
		
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
