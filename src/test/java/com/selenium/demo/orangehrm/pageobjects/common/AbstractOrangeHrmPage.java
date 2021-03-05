package com.selenium.demo.orangehrm.pageobjects.common;

import org.openqa.selenium.WebDriver;

import com.selenium.demo.orangehrm.pageobjects.navigation.NavigationLeftSideBar;
import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;

public class AbstractOrangeHrmPage extends AbstractPage {
	
	private NavigationLeftSideBar navigationLeftSideBar;

	public AbstractOrangeHrmPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
		navigationLeftSideBar = new NavigationLeftSideBar(driver, browser);
	}
	
	public NavigationLeftSideBar getNavigation() {
		return this.navigationLeftSideBar;
	}

}
