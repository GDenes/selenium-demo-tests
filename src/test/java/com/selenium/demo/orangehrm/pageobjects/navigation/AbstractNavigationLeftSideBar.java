package com.selenium.demo.orangehrm.pageobjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.expenseclaimspage.ExpenseClaimsPage;
import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public abstract class AbstractNavigationLeftSideBar extends AbstractPage {
	
	@FindBy(id = "menu-content")
	private WebElement menuItemList;
	
	@FindBy(id = "menu_expense_viewExpenseModule")
	private WebElement expenseManuItem;

	@FindBy(id = "menu_expense_Claims")
	private WebElement claimsSubMenuItem;
	
	@FindBy(id = "menu_expense_viewExpenseClaims")
	private WebElement underClaimsEmployeeSubMenuItem;

	public AbstractNavigationLeftSideBar(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(menuItemList);
	}
	
	public ExpenseClaimsPage navigateToExponseClaimsPage() {
		expenseManuItem.click();
		new WaitForElementToAppear(driver).apply(claimsSubMenuItem);
		claimsSubMenuItem.click();
		new WaitForElementToAppear(driver).apply(underClaimsEmployeeSubMenuItem);
		underClaimsEmployeeSubMenuItem.click();
		return new ExpenseClaimsPage(driver, browser);
	}

}
