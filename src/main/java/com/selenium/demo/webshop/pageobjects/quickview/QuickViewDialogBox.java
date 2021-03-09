package com.selenium.demo.webshop.pageobjects.quickview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class QuickViewDialogBox extends AbstractPage {
	
	@FindBy(css = "#short_description_content")
	private WebElement description;
	
	@FindBy(css = ".fancybox-iframe")
	private WebElement iframe;
	
	public QuickViewDialogBox(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		new WaitForElementToAppear(driver).apply(iframe);
	}

	
	public String getDescriptionText() {
		driver.switchTo().frame(iframe);
		return new WaitForElementToAppear(driver).apply(description).getText();
	}
}
