package com.selenium.demo.toolsqa.pageobjects.uploadanddownloadpage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class UploadAndDownloadPage extends AbstractPage {
	
	private static final String TEST_DATA_FILE =System.getProperty("user.dir") + File.separator +"test_data" + File.separator +"sampleFile.jpeg";
	
	@FindBy(css = "#uploadFile")
	private WebElement uploadFile;

	@FindBy(css = "#uploadedFilePath")
	private WebElement filePath;
	
	public UploadAndDownloadPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		
		new WaitForElementToAppear(driver).apply(uploadFile);
	}
	
	public void uploadSampleFile() {
		uploadFile.sendKeys(TEST_DATA_FILE);
	}
	
	public String getFilePathText() {
		return new WaitForElementToAppear(driver).apply(filePath).getText();
	}

}
