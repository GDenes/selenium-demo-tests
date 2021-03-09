package com.selenium.demo.webshop.pageobjects.fadedshortpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;
import com.selenium.demo.webshop.pageobjects.orderpage.OrderPage;

public class AddCartDialogBox extends AbstractWebShopPage {

	@FindBy(css = "#layer_cart_product_title")
	private WebElement productTitle;
	
	@FindBy(css = "#layer_cart_product_attributes")
	private WebElement colorAndSize;
	
	@FindBy(css = "a.button-medium > span")
	private WebElement proceedToCheckoutButton;
	
	public AddCartDialogBox(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(productTitle);
		new WaitForElementToAppear(driver).apply(proceedToCheckoutButton);
	}
	
	
	public String getProductTitleText() {
		return productTitle.getText();
	}
	
	public String getColorAndSizeText() {
		return colorAndSize.getText();
	}
	
	public OrderPage clickProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
		return new OrderPage(driver, browser);
	}
}
