package com.selenium.demo.orangehrm.pageobjects.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class LoginPage extends AbstractPage {

	@FindBy(id = "txtUsername")
	private WebElement usernameInputField;
	
	@FindBy(id = "txtPassword")
	private WebElement passwordInputField;
	
	@FindBy(id = "btnLogin")
	private WebElement loginButton;

	public LoginPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);
		
		waitForElementToAppear.apply(usernameInputField);
		waitForElementToAppear.apply(passwordInputField);
		waitForElementToAppear.apply(loginButton);
	}

	/*
	* On the login page, credentials are pre-entered. In tests used different users for testing, but function was not
	* deleted, if it was to be used later
	* */
	public DashboardPage loginWithDefaultCredential() {
		loginButton.click();
		return new DashboardPage(driver, browser);
	}
	
	public DashboardPage loginWithCredential(final String username, final String password) {
		clearInputFields();
		usernameInputField.sendKeys(username);
		passwordInputField.sendKeys(password);
		
		loginButton.click();
		
		return new DashboardPage(driver, browser);
	}
	
	private void clearInputFields() {
		usernameInputField.clear();
		passwordInputField.clear();
	}

}
