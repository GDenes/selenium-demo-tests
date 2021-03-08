package com.selenium.demo.orangehrm.pageobjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.userpage.UsersPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class AdminNavigationLeftSideBar extends AbstractNavigationLeftSideBar {

	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement adminModuleButton;
	
	@FindBy(id = "menu_admin_UserManagement")
	private WebElement userModuleButton;
	
	@FindBy(id = "menu_admin_viewSystemUsers")
	private WebElement userButton;
	
	public AdminNavigationLeftSideBar(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(adminModuleButton);
	}
	
	public UsersPage navigateToUserPages() {
		clickToAdminItem();
		clickToUserManagementItem();
		userButton.click();
		return new UsersPage(driver, browser);
	}
	
	private void clickToAdminItem() {
		adminModuleButton.click();
		new WaitForElementToAppear(driver).apply(userModuleButton);
	}
	
	private void clickToUserManagementItem() {
		userModuleButton.click();
		new WaitForElementToAppear(driver).apply(userButton);
	}

}
