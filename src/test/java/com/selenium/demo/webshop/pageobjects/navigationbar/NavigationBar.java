package com.selenium.demo.webshop.pageobjects.navigationbar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.tshirtpage.TShirtsPage;

public class NavigationBar extends AbstractPage {
	@FindBy(css = ".sf-with-ul[title='Women']")
	private WebElement womenButton;
	
	@FindBy(css = "ul.sf-menu > li > [title='Dresses']")
	private WebElement dressesButton;

	@FindBy(css = "ul.sf-menu .submenu-container [title='T-shirts']")
	private WebElement TShirtsButton;

	public NavigationBar(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
		
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		new WaitForElementToAppear(driver).apply(womenButton);
		new WaitForElementToAppear(driver).apply(dressesButton);
	}
	
	public TShirtsPage hoverAndClickTshirtsButton() {
		Actions action = new Actions(driver);
		action.moveToElement(womenButton).perform();
		//womenButton.click();
		new WaitForElementToAppear(driver).apply(TShirtsButton).click();
		return new TShirtsPage(driver, browser);
	}

}
