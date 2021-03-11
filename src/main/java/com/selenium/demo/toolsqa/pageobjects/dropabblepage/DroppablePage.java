package com.selenium.demo.toolsqa.pageobjects.dropabblepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class DroppablePage extends AbstractPage {
	
	@FindBy(id = "draggable")
	private WebElement draggableComponent;
	
	@FindBy(id = "droppable")
	private WebElement droppableSquareComponent;

	public DroppablePage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);
		
		waitForElementToAppear.apply(draggableComponent);
		waitForElementToAppear.apply(droppableSquareComponent);
	}
	
	public WebElement getDraggableComponent() {
		return draggableComponent;
	}

	public WebElement getDroppableSquareComponent() {
		return droppableSquareComponent;
	}

	public String getDroppableSquareComponentText() {
		return droppableSquareComponent.getText();
	}

	public String getDroppableSquareComponentBackgroundValue() {
		return droppableSquareComponent.getCssValue("background-color");
	}
}
