package com.selenium.demo.toolsqa.pageobjects.widgetspage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.toolsqa.pageobjects.tooltipspage.ToolTipsPage;
import com.selenium.demo.wait.WaitForElementToAppear;

public class WidgetsPage extends AbstractPage {
	
	private static final int WAIT = 10;

	@FindBy(css = ".show.element-list li:nth-of-type(7)")
	private WebElement toolTips;

	@FindBy(css = "body")
	private WebElement body;

	public WidgetsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		waitForElementToAppear.apply(toolTips);
		waitForElementToAppear.apply(body);
	}

	public ToolTipsPage navigateToToolTipsPage() {
		body.sendKeys(Keys.PAGE_DOWN);

		final WebDriverWait wait = new WebDriverWait(driver, WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(toolTips)).click();
		return new ToolTipsPage(driver, browser);
	}
}
