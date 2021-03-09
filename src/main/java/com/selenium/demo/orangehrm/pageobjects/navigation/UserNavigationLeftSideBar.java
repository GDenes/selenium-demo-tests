package com.selenium.demo.orangehrm.pageobjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.myinfo.MyInfoPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class UserNavigationLeftSideBar extends AbstractNavigationLeftSideBar {
	
	@FindBy(id = "menu_pim_viewMyDetails")
	private WebElement myInfoMenuItem;

	public UserNavigationLeftSideBar(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(myInfoMenuItem);
	}
	
	
	public MyInfoPage navigateToMyInfoPage() {
		myInfoMenuItem.click();
		return new MyInfoPage(driver, browser);
	}

}
