package com.selenium.demo.testbase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.selenium.demo.testbase.drivers.DriverFactory;

public abstract class TestBase {

	protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

	protected static final BrowsersEnum browser = BrowsersEnum.CHROME_HEADLESS;
	private WebDriver driver = new DriverFactory().createDriver(browser);

	@BeforeEach
	public void setUp() throws Exception {
		if (driver == null) {
			driver = new DriverFactory().createDriver(browser);
		}
	}

	@AfterEach
	public void afterClass() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static BrowsersEnum getBrowser() {
		return browser;
	}

}
