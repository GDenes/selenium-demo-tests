package com.selenium.demo.toolsqa.pageobjects.tooltipspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class ToolTipsPage extends AbstractPage {

	private static final int WAIT = 10;
	private static final int PAUSE = 500;
	
	@FindBy(css = "#toolTipButton")
	private WebElement toolTipButton;

	@FindBy(css = "#toolTipTextField")
	private WebElement toolTipTextField;

	@FindBy(css = ".tooltip-inner")
	private WebElement toolTipText;

	public ToolTipsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		waitForElementToAppear.apply(toolTipButton);
		waitForElementToAppear.apply(toolTipTextField);
	}

	public String hoverToolTipButtonAndGetText() {
		return hoverWebElementAndGetToolTipText(toolTipButton);
	}

	public String hoverToolTipTextFieldAndGetText() {
		return hoverWebElementAndGetToolTipText(toolTipTextField);
	}

	private String hoverWebElementAndGetToolTipText(WebElement webElement) {
		final Actions action = new Actions(driver);
		action.pause(PAUSE).perform();
		action.moveToElement(webElement).perform();
		action.pause(PAUSE).perform();
		
		final WebDriverWait wait = new WebDriverWait(driver, WAIT);
		return wait.until(ExpectedConditions.visibilityOf(toolTipText)).getText();
	}

}
