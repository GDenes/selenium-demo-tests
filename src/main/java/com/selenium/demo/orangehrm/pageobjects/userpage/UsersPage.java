package com.selenium.demo.orangehrm.pageobjects.userpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.enums.UserEnum;
import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class UsersPage extends AbstractOrangeHrmPage {

	private static final String GET_ATTRIBUTE_VALUE = "value";

	@FindBy(id = "systemUserDiv")
	private WebElement usersTable;

	@FindBy(css = "input.select-dropdown")
	private WebElement userListSize;

	@FindBy(css = ".page-title")
	private WebElement pageTitle;

	@FindBy(css = ".highlight > tbody:nth-child(3) > tr")
	private List<WebElement> userRowElements;

	@FindBy(css = ".highlight > tbody:nth-child(3) > tr:nth-child(1)")
	private WebElement firstRowInTable;

	public UsersPage(WebDriver driver, BrowsersEnum browser, UserEnum userEnum) {
		super(driver, browser, userEnum);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		waitForElementToAppear.apply(pageTitle);
		waitForElementToAppear.apply(usersTable);
		waitForElementToAppear.apply(userListSize);
		waitForElementToAppear.apply(firstRowInTable);
	}

	public int getUserListSize() {
		return Integer.parseInt(userListSize.getAttribute(GET_ATTRIBUTE_VALUE));
	}

	public List<WebElement> getAllUserName() {
		return userRowElements;
	}

}
