package com.selenium.demo.pageobjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.selenium.demo.testbase.BrowsersEnum;

public abstract class AbstractPage extends LoadableComponent<AbstractPage> {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);

	protected WebDriver driver;
	protected BrowsersEnum browser;

	public AbstractPage(final WebDriver driver, BrowsersEnum browser) {
		this.driver = driver;
		this.browser = browser;

		logger.info("Currently on page: " + this.getClass().getSimpleName());

		PageFactory.initElements(driver, this);
		this.get();
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {

	}
}