package com.selenium.demo.testbase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;

public abstract class OrangeHrmTestBase extends TestBase {
	
	private static final String BASE_URL = "https://orangehrm-demo-6x.orangehrmlive.com";
	
	public LoginPage navigateToOrangeHrmPage() {
		getDriver().get(BASE_URL);;
		return new LoginPage(getDriver(), getBrowser());
	}
	
	protected void printAllUserNameToTerminal(List<WebElement> rows, final String filterTagName) {
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).findElement(By.tagName(filterTagName)).getText());
		}
	}

}
