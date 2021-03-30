package com.selenium.demo.orangehrm.pageobjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.enums.PageEnum;
import com.selenium.demo.orangehrm.enums.UserEnum;
import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.orangehrm.pageobjects.expenseclaimspage.ExpenseClaimsPage;
import com.selenium.demo.orangehrm.pageobjects.userpage.UsersPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

import static org.junit.jupiter.api.Assertions.fail;

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

	@Override public AbstractOrangeHrmPage navigateTo(PageEnum pageEnum) {
		switch (pageEnum) {
			case USER_PAGE: return navigateToUserPages();
			case EXPENSE_CLAIMS_PAGE: return navigateToExpenseClaimsPage();
		}
		return fail("Page not implemented!");
	}

	@Override
	public ExpenseClaimsPage navigateToExpenseClaimsPage() {
		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		expenseMenuItem.click();
		waitForElementToAppear.apply(claimsSubMenuItem);
		claimsSubMenuItem.click();
		waitForElementToAppear.apply(underClaimsEmployeeSubMenuItem);
		underClaimsEmployeeSubMenuItem.click();

		return new ExpenseClaimsPage(driver, browser, UserEnum.SYSTEM_ADMIN);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(adminModuleButton);
	}
	
	private UsersPage navigateToUserPages() {
		clickToAdminItem();
		clickToUserManagementItem();
		userButton.click();
		return new UsersPage(driver, browser, UserEnum.SYSTEM_ADMIN);
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
