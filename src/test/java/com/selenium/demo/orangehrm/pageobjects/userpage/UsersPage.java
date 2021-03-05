package com.selenium.demo.orangehrm.pageobjects.userpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class UsersPage extends AbstractOrangeHrmPage {
	
	@FindBy(id = "systemUserDiv")
	private WebElement usersTable;
	
	@FindBy(css = "input.select-dropdown")
	private WebElement userListSize;
	
	@FindBy(css = ".page-title")
	private WebElement pageTitle;
	
	@FindBy(css = ".highlight > tbody:nth-child(3) > tr")
	private List<WebElement> userRowElements; 
	
	public UsersPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(pageTitle);
		new WaitForElementToAppear(driver).apply(usersTable);
		new WaitForElementToAppear(driver).apply(userListSize);
	}
	
	public int getUserListSize() {
		return Integer.parseInt(userListSize.getAttribute("value"));
	}
	
	public List<WebElement> getAllUserName() {
		return userRowElements;
	}

}
