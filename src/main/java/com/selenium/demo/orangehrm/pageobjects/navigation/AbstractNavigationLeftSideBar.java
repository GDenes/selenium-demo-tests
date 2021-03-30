package com.selenium.demo.orangehrm.pageobjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public abstract class AbstractNavigationLeftSideBar extends AbstractPage implements HeaderInterface, CommonNavigationInterface {

	@FindBy(id = "menu-content")
	private WebElement menuItemList;

	@FindBy(id = "menu_expense_viewExpenseModule")
	protected WebElement expenseMenuItem;

	@FindBy(id = "menu_expense_Claims")
	protected WebElement claimsSubMenuItem;

	@FindBy(id = "menu_expense_viewExpenseClaims")
	protected WebElement underClaimsEmployeeSubMenuItem;

	public AbstractNavigationLeftSideBar(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(menuItemList);
	}

}
