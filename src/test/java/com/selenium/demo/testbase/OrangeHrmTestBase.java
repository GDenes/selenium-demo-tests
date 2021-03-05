package com.selenium.demo.testbase;

import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;

public abstract class OrangeHrmTestBase extends TestBase {
	
	private static final String BASE_URL = "https://orangehrm-demo-6x.orangehrmlive.com";
	
	public LoginPage navigateToOrangeHrmPage() {
		getDriver().get(BASE_URL);;
		return new LoginPage(getDriver(), getBrowser());
	}

}
