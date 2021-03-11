package com.selenium.demo.testbase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;

public abstract class OrangeHrmTestBase extends TestBase {
	
	private static final String BASE_URL = "https://orangehrm-demo-6x.orangehrmlive.com";

	protected static final String SYS_ADMIN_USERNAME = "_ohrmSysAdmin_";
	protected static final String SYS_ADMIN_PASSWORD = "sysadmin";
	
	public LoginPage navigateToOrangeHrmPage() {
		getDriver().get(BASE_URL);
		return new LoginPage(getDriver(), getBrowser());
	}
	
	protected void printAllUserNameToTerminal(List<WebElement> rows, final String filterTagName) {
		for (WebElement row : rows) {
			System.out.println(row.findElement(By.tagName(filterTagName)).getText());
		}
	}

}
