package com.selenium.demo.orangehrm.pageobjects.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
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

		new WaitForElementToAppear(driver).apply(usernameInputField);
		new WaitForElementToAppear(driver).apply(passwordInputField);
		new WaitForElementToAppear(driver).apply(loginButton);
	}
	
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
