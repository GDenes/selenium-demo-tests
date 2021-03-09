package com.selenium.demo.webshop.pageobjects.searchpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;
import com.selenium.demo.webshop.pageobjects.quickview.QuickViewDialogBox;

public class SearchPage extends AbstractWebShopPage {
	
	@FindBy(css = "div.left-block > .product-image-container")
	private WebElement firstElement;

	public SearchPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
	}

	public QuickViewDialogBox clickFirstElement() {
		firstElement.click();
		
		return new QuickViewDialogBox(driver, browser);
	}
}
