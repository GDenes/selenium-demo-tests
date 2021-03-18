package com.selenium.demo.testbase.driver.config;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeConfig extends GenericConfig {

	protected static final Logger logger = LoggerFactory.getLogger(ChromeConfig.class);

	public ChromeOptions getOptions () {
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--proxy-server='direct://'");
		options.addArguments("--proxy-bypass-list=*");
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("disable-infobars");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		
		//options.setCapability(CapabilityType.LOGGING_PREFS, logTypes());
		logger.trace("Chrome option capabilities set");
		
		return options;
	}
}
