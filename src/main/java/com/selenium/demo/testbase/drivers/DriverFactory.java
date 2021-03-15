package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;

import com.selenium.demo.testbase.BrowsersEnum;

public class DriverFactory {

	public WebDriver createDriver(final BrowsersEnum browser) {
		switch (browser) {
		case CHROME:
			return new ChromeFactory().getDriver();
		case CHROME_HEADLESS:
			return new ChromeHeadlessFactory().getDriver();
		case FIREFOX:
			return new FirefoxFactory().getDriver();
		case FIREFOX_HEADLESS:
			return new FirefoxHeadLessFactory().getDriver();
		case EDGE:
			return new EdgeFactory().getDriver();
		default:
			throw new UnsupportedOperationException("Browser type is not yet supported");
		}
	}
}