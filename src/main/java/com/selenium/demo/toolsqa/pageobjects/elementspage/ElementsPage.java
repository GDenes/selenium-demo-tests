package com.selenium.demo.toolsqa.pageobjects.elementspage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.toolsqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage;
import com.selenium.demo.toolsqa.pageobjects.uploadanddownloadpage.UploadAndDownloadPage;
import com.selenium.demo.wait.WaitForElementToAppear;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class ElementsPage extends AbstractPage {

	@FindBy(css = "div.show li:nth-of-type(9)")
	private WebElement dynamicProperties;

	@FindBy(css = "div.show li:nth-of-type(8)")
	private WebElement uploadAndDownload;

	@FindBy(css = "body")
	private WebElement body;

	public ElementsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(uploadAndDownload);
	}

	public DynamicPropertiesPage navigateToDynamicPropertiesPage() {
		body.sendKeys(Keys.PAGE_DOWN);

		new WaitForElementToAppear(driver).apply(dynamicProperties).click();
		return new DynamicPropertiesPage(driver, browser);
	}

	public UploadAndDownloadPage navigateToUploadAndDownloadPage() {
		uploadAndDownload.click();
		return new UploadAndDownloadPage(driver, browser);
	}
}
