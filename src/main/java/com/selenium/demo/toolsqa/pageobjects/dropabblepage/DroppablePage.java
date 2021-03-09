package com.selenium.demo.toolsqa.pageobjects.dropabblepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class DroppablePage extends AbstractPage {
	
	@FindBy(id = "draggable")
	private WebElement dragabbleComponent;
	
	@FindBy(id = "droppable")
	private WebElement dropableleSquareComponent;

	public DroppablePage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);
		
		waitForElementToAppear.apply(dragabbleComponent);
		waitForElementToAppear.apply(dropableleSquareComponent);
	}
	
	public WebElement getDragabbleComponent() {
		return dragabbleComponent;
	}

	public WebElement getDropableleSquareComponent() {
		return dropableleSquareComponent;
	}

	public String getDroppableSquareComponentText() {
		return dropableleSquareComponent.getText();
	}

	public String getDroppableSquareComponentBackgroundValue() {
		return dropableleSquareComponent.getCssValue("background-color");
	}
}
