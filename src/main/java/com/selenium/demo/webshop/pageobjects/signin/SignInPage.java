package com.selenium.demo.webshop.pageobjects.signin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;

public class SignInPage extends AbstractWebShopPage {

	@FindBy(css = ".page-heading")
	private WebElement pageHead;

	@FindBy(css = "button#SubmitCreate > span")
	private WebElement createAccountButton;

	@FindBy(css = "button#SubmitLogin > span")
	private WebElement signInButton;

	@FindBy(css = "li.step_current > span")
	private WebElement currentStep;

	public SignInPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		waitForElementToAppear.apply(pageHead);
		waitForElementToAppear.apply(createAccountButton);
		waitForElementToAppear.apply(currentStep);
		waitForElementToAppear.apply(signInButton);
	}

	public String getHeadText() {
		return pageHead.getText();
	}

	public String getCurrentStepText() {
		return currentStep.getText();
	}

}
