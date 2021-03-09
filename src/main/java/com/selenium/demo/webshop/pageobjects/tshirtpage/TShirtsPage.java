package com.selenium.demo.webshop.pageobjects.tshirtpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;
import com.selenium.demo.webshop.pageobjects.fadedshortpage.FadedShortPage;

public class TShirtsPage extends AbstractWebShopPage {
	
	@FindBy(css = ".product-name[title='Faded Short Sleeve T-shirts']")
	private WebElement fadedShortItem;

	public TShirtsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		new WaitForElementToAppear(driver).apply(fadedShortItem);
	}
	
	public FadedShortPage clickFadedShortItem() {
		fadedShortItem.click();
		
		return new FadedShortPage(driver, browser);
	}

}
