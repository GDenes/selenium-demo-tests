package com.selenium.demo.webshop.pageobjects.fadedshortpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;

public class AddCartDialogBox extends AbstractWebShopPage {

	@FindBy(css = "#layer_cart_product_title")
	private WebElement productTitle;
	
	@FindBy(css = "#layer_cart_product_attributes")
	private WebElement colorAndSize;
	
	public AddCartDialogBox(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(productTitle);
	}
	
	
	public String getProductTitleText() {
		return productTitle.getText();
	}
	
	public String getColorAndSizeText() {
		return productTitle.getText();
	}
}
