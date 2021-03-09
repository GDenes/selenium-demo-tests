package com.selenium.demo.testbase;

import com.selenium.demo.toolsqa.pageobjects.NavigationPage;

public class ToolsQATestBase extends TestBase {

	private static final String BASE_URL = "https://demoqa.com/";

	public NavigationPage navigateToToolsQAPage() {
		getDriver().get(BASE_URL);

		return new NavigationPage(getDriver(), browser);
	}
}
