package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.selenium.demo.testbase.driver.config.ChromeConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

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

	@Override
	public WebDriver getRemoteWebDriver(String remoteUrl) {
		final ChromeOptions options = new ChromeConfig().getOptions();
		options.addArguments("--headless");

		final WebDriver driver =  RemoteWebDriver.builder()
				.addAlternative(options)
				.url(remoteUrl)
				.build();
		maximize(driver);

		return driver;
	}

}