package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.selenium.demo.testbase.driver.config.ChromeConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadlessFactory extends GenericFactory implements DriverInterface {

	@Override
	public WebDriver getDriver() {
		logger.trace("Initializing local headless chromedriver...");
		WebDriverManager.chromedriver().setup();

		final ChromeOptions options = new ChromeConfig().getOptions();
		options.addArguments("--headless");
		
		ChromeDriver driver = new ChromeDriver(options);
		maximize(driver);
		
		logger.trace("Local headless chromedriver initialized.");
		return driver;
	}
}