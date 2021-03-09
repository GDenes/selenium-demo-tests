package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.selenium.demo.testbase.driver.config.FirefoxConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxHeadLessFactory extends GenericFactory implements DriverInterface {

	@Override
	public WebDriver getDriver() {
		WebDriverManager.firefoxdriver().setup();	
		
		FirefoxOptions options = new FirefoxConfig().getOptions();
		options.addArguments("--headless");
		
		final FirefoxDriver driver = new FirefoxDriver(options);
		maximize(driver);
		
		logger.trace("Local headless firefox driver initialized.");
		return driver;
	}

}
