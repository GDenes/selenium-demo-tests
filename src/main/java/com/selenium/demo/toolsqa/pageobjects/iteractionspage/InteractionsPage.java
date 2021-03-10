package com.selenium.demo.toolsqa.pageobjects.iteractionspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.toolsqa.pageobjects.dropabblepage.DroppablePage;
import com.selenium.demo.wait.WaitForElementToAppear;

public class InteractionsPage extends AbstractPage {
	
	@FindBy(css = "div.show:nth-child(2) > ul:nth-child(1) > li:nth-child(1)")
	private WebElement sortableMenuItem;
	
	@FindBy(css = "div.show:nth-child(2) > ul:nth-child(1) > li:nth-child(2)")
	private WebElement selectableMenuItem;
	
	@FindBy(css = "div.show:nth-child(2) > ul:nth-child(1) > li:nth-child(3)")
	private WebElement resizebleMenuItem;
	
	@FindBy(css = "div.show:nth-child(2) > ul:nth-child(1) > li:nth-child(4)")
	private WebElement droppableMenuItem;
	
	@FindBy(css = "div.show:nth-child(2) > ul:nth-child(1) > li:nth-child(5)")
	private WebElement dragabbleMenuItem;

	public InteractionsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(droppableMenuItem);
	}
	
	public DroppablePage getDroppablePage() {
		droppableMenuItem.click();
		return new DroppablePage(driver, browser);
	}

}
