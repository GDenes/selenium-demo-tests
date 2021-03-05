package com.selenium.demo.webshop.pageobjects.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;
import com.selenium.demo.webshop.pageobjects.common.AbstractWebShopPage;

public class HomePage extends AbstractWebShopPage {

	@FindBy(css = "ul#homefeatured [alt='Faded Short Sleeve T-shirts']")
	private WebElement girlInTheRedDress;

	public HomePage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(girlInTheRedDress);
	}

	public WebElement getGirlInTheRedDress() {
		return girlInTheRedDress;
	}

}
