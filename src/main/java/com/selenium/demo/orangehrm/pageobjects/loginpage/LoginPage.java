package com.selenium.demo.orangehrm.pageobjects.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.enums.UserEnum;
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

	public DashboardPage login(UserEnum userEnum) {
		clearInputFields();
		usernameInputField.sendKeys(userEnum.getUsername());
		passwordInputField.sendKeys(userEnum.getPassword());

		loginButton.click();

		return new DashboardPage(driver, browser, userEnum);
	}
	
	private void clearInputFields() {
		usernameInputField.clear();
		passwordInputField.clear();
	}

}
