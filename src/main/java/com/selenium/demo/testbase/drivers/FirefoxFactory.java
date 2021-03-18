package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.demo.testbase.driver.config.FirefoxConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxFactory extends GenericFactory implements DriverInterface {

	@Override
	public WebDriver getDriver() {
		logger.trace("Initializing local firefox driver...");
		WebDriverManager.firefoxdriver().setup();	

		FirefoxDriver driver = new FirefoxDriver(new FirefoxConfig().getOptions());
		maximize(driver);
		
		logger.trace("Local firefox driver initialized.");
		return driver;
	}

	@Override
	public WebDriver getRemoteWebDriver(String remoteUrl) {
		final WebDriver driver =  RemoteWebDriver.builder()
				.addAlternative(new FirefoxConfig().getOptions())
				.url(remoteUrl)
				.build();
		maximize(driver);

		return driver;
	}

}