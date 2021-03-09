package com.selenium.demo.testbase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.selenium.demo.testbase.drivers.DriverFactory;


public abstract class TestBase {
	
	protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

	protected static final BrowsersEnum browser = BrowsersEnum.CHROME_HEADLESS;
	protected static final String PIPELINE_HISTORY_PAGE = "http://localhost"; 
	private static WebDriver driver = new DriverFactory().createDriver(browser);
	
	@BeforeEach
	public void setUp() throws Exception {
		if (driver == null) {
			driver = new DriverFactory().createDriver(browser);
		}
	}
	
	@AfterAll
	public static void afterClass() {
		driver.close();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static BrowsersEnum getBrowser() {
		return browser;
	}
	
}
