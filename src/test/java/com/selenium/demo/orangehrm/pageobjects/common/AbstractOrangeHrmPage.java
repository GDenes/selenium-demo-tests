package com.selenium.demo.orangehrm.pageobjects.common;

import org.openqa.selenium.WebDriver;

import com.selenium.demo.orangehrm.pageobjects.navigation.AdminNavigationLeftSideBar;
import com.selenium.demo.orangehrm.pageobjects.navigation.HeaderInterface;
import com.selenium.demo.orangehrm.pageobjects.navigation.UserNavigationLeftSideBar;
import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;

public class AbstractOrangeHrmPage extends AbstractPage implements HeaderInterface {

	public AbstractOrangeHrmPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	public AdminNavigationLeftSideBar getAdminNavigation() {
		return new AdminNavigationLeftSideBar(driver, browser);
	}

	@Override
	public UserNavigationLeftSideBar getUserNavigation() {
		return new UserNavigationLeftSideBar(driver, browser);
	}
	
}
