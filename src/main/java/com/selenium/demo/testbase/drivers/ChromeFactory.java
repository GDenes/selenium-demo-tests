package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.demo.testbase.driver.config.ChromeConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeFactory extends GenericFactory implements DriverInterface {

	@Override
	public WebDriver getDriver() {
		logger.trace("Initializing local chromedriver...");
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver(new ChromeConfig().getOptions());
		maximize(driver);
		
		logger.trace("Local chrome driver initialized.");
		return driver;
	}

	@Override
	public WebDriver getRemoteWebDriver(String remoteUrl) {
		final WebDriver driver = RemoteWebDriver.builder()
				.addAlternative(new ChromeConfig().getOptions())
				.url(remoteUrl)
				.build();
		maximize(driver);

		return driver;
	}
}