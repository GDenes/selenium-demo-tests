package com.selenium.demo.webshop.pageobjects.common;

import org.openqa.selenium.WebDriver;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.webshop.pageobjects.navigationbar.NavigationBar;

public abstract class AbstractWebShopPage extends AbstractPage {

	private NavigationBar navigationBar;

	public AbstractWebShopPage(WebDriver driver, BrowsersEnum browser) {

		super(driver, browser);
		navigationBar = new NavigationBar(driver, browser);
	}

	public NavigationBar getNavigationBar() {
		return navigationBar;
	}
}
