package com.selenium.demo.testbase.driver.config;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FirefoxConfig extends GenericConfig {

	protected static final Logger logger = LoggerFactory.getLogger(FirefoxConfig.class);
	
	public FirefoxOptions getOptions () {
		final FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--proxy-server='direct://'");
		options.addArguments("--proxy-bypass-list=*");
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");

		logger.trace("Firefox option capabilities set");
		return options;
	}
}
