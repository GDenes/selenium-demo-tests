package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericFactory {
	protected static final Logger logger = LoggerFactory.getLogger(GenericFactory.class);

	protected void maximize(WebDriver driver) {
		driver.manage().window().maximize();
		logger.debug("Browser maximized");
	}

}