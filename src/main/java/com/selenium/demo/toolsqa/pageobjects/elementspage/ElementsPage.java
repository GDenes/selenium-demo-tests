package com.selenium.demo.toolsqa.pageobjects.elementspage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.toolsqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage;
import com.selenium.demo.toolsqa.pageobjects.uploadanddownloadpage.UploadAndDownloadPage;
import com.selenium.demo.wait.WaitForElementToAppear;

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
		final JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView()", dynamicProperties);

		new WaitForElementToAppear(driver).apply(dynamicProperties).click();
		return new DynamicPropertiesPage(driver, browser);
	}

	public UploadAndDownloadPage navigateToUploadAndDownloadPage() {
		uploadAndDownload.click();
		return new UploadAndDownloadPage(driver, browser);
	}
}
