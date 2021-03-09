package com.selenium.demo.webshop.pageobjects.orderpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;
import com.selenium.demo.webshop.pageobjects.signin.SignInPage;

public class OrderPage extends AbstractWebShopPage {

	@FindBy(css = "#total_product")
	private WebElement totalProduct;

	@FindBy(css = "#total_shipping")
	private WebElement totalShipping;

	@FindBy(css = "#total_tax")
	private WebElement totalTax;

	@FindBy(css = "#total_price")
	private WebElement totalPrice;

	@FindBy(css = "a.standard-checkout > span")
	private WebElement proceedToCheckoutButton;

	public OrderPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		waitForElementToAppear.apply(totalProduct);
		waitForElementToAppear.apply(totalShipping);
		waitForElementToAppear.apply(totalTax);
		waitForElementToAppear.apply(totalPrice);
		waitForElementToAppear.apply(proceedToCheckoutButton);
	}

	public SignInPage clickProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
		return new SignInPage(driver, browser);
	}

	public String getTotalProductText() {
		return totalProduct.getText();
	}

	public String getTotalShippingText() {
		return totalShipping.getText();
	}

	public String getTotalTaxText() {
		return totalTax.getText();
	}

	public String getTotalPriceText() {
		return totalPrice.getText();
	}

}
