package com.selenium.demo.orangehrm.pageobjects.dashboardpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.orangehrm.pageobjects.navigation.AbstractNavigationLeftSideBar;
import com.selenium.demo.orangehrm.pageobjects.navigation.AdminNavigationLeftSideBar;
import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class DashboardPage extends AbstractOrangeHrmPage {
	
	@FindBy(className = "page-title")
	private WebElement pageTitle;
	
	@FindBy(id = "content")
	private WebElement pageContent;

	public DashboardPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(pageTitle);
		new WaitForElementToAppear(driver).apply(pageContent);
	}

}
