package com.selenium.demo.testbase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.selenium.demo.webshop.pageobjects.homepage.HomePage;

public class WebShopTestBase extends TestBase {
	private static final String BASE_URL = "http://automationpractice.com/index.php";
	private static final String SCREENSHOT_FILE_PATH = "target/screenshots/";

	public HomePage navigateToWebShopPage() {
		getDriver().get(BASE_URL);

		return new HomePage(getDriver(), browser);
	}

	public void createScreenShotByElement(WebElement element, String fileName) {
		File screenShot = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(SCREENSHOT_FILE_PATH + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
