package com.selenium.demo.testbase;

import com.selenium.demo.webshop.pageobjects.homepage.HomePage;

public class WebShopTestBase extends TestBase {
	private static final String BASE_URL = "http://automationpractice.com/index.php";

	public HomePage navigateToWebShopPage() {
		getDriver().get(BASE_URL);

		return new HomePage(getDriver(), browser);
	}
}
