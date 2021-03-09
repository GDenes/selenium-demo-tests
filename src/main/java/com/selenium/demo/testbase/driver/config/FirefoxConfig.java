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
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, application/pdf, image/png, image/jpeg");
		firefoxProfile.setPreference("pdfjs.disabled", true);
		firefoxProfile.setPreference("pdfjs.enabledCache.state", false);
		options.setCapability("marionette", true);
		options.setProfile(firefoxProfile);
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--proxy-server='direct://'");
		options.addArguments("--proxy-bypass-list=*");
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		
		options.setCapability(CapabilityType.LOGGING_PREFS, logTypes());
		logger.trace("Firefox option capabilities set");
		return options;
	}
}
