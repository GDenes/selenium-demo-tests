package com.selenium.demo.webshop.pageobjects.fadedshortpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.enums.ColorEnum;
import com.selenium.demo.webshop.enums.SizeEnum;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;

public class FadedShortPage extends AbstractWebShopPage {

	@FindBy(css = ".icon-plus")
	private WebElement increaseQuantityButton;

	@FindBy(css = ".attribute_select")
	private WebElement sizeInputField;

	@FindBy(css = "[name='Blue']")
	private WebElement blueColor;

	@FindBy(css = "[name='Orange']")
	private WebElement orangeColor;

	@FindBy(css = "button[name='Submit'] > span")
	private WebElement addToCartButton;

	public FadedShortPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(increaseQuantityButton);
	}

	public void increaseQuantityNumber() {
		increaseQuantityButton.click();
	}

	public void selectSize(SizeEnum sizeText) {
		Select size = new Select(sizeInputField);
		size.selectByVisibleText(sizeText.getText());

	}
	
	public AddCartDialogBox clickAddCartButton() {
		addToCartButton.click();
		return new AddCartDialogBox(driver, browser);
	}

	public void selectColor(ColorEnum color) {
		switch (color) {
		case BLUE:
			blueColor.click();
			break;
		case ORANGE:
			orangeColor.click();
			break;

		}
	}

}
