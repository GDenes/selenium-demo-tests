package com.selenium.demo.toolsqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.toolsqa.pageobjects.elementspage.ElementsPage;
import com.selenium.demo.toolsqa.pageobjects.iteractionspage.InteractionsPage;
import com.selenium.demo.toolsqa.pageobjects.widgetspage.WidgetsPage;
import com.selenium.demo.wait.WaitForElementToAppear;

public class NavigationPage extends AbstractPage {

	@FindBy(css = "div.category-cards > div:nth-of-type(1) > div")
	private WebElement elements;
	
	@FindBy(css = "div.category-cards > div:nth-of-type(2) > div")
	private WebElement forms;
	
	@FindBy(css = "div.category-cards > div:nth-of-type(3) > div")
	private WebElement alertsFrameWindow;
	
	@FindBy(css = "div.category-cards > div:nth-of-type(4)")
	private WebElement widgets;
	
	@FindBy(css = "div.category-cards > div:nth-of-type(5)")
	private WebElement interactions;
	
	@FindBy(css = "div.category-cards > div:nth-of-type(6) > div")
	private WebElement bookStoreApplication;


	public NavigationPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);
		
		waitForElementToAppear.apply(elements);
		waitForElementToAppear.apply(forms);
		waitForElementToAppear.apply(alertsFrameWindow);
		waitForElementToAppear.apply(widgets);
		waitForElementToAppear.apply(interactions);
		waitForElementToAppear.apply(bookStoreApplication);
	}
	
	public WidgetsPage navigateToWidgetsPage() {
		widgets.click();
		return new WidgetsPage(driver, browser);
	}

	public ElementsPage navigateToElementsPage() {
		elements.click();
		return new ElementsPage(driver, browser);
	}
	
	public InteractionsPage navigateToInteractionsPage() {
		interactions.click();
		return new InteractionsPage(driver, browser);
	}
	
}
