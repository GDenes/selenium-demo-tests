package com.selenium.demo.orangehrm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;
import com.selenium.demo.orangehrm.pageobjects.userpage.UsersPage;
import com.selenium.demo.testbase.OrangeHrmTestBase;

public class OrangeHrmTests extends OrangeHrmTestBase {

	private static final int ROW_PER_PAGE = 50;

	DashboardPage dashboardPage;

	@BeforeEach
	public void beforeTest() {
		final LoginPage loginPage = navigateToOrangeHrmPage();
		dashboardPage = loginPage.loginWithDefaultCredential();
	}

	@Test
	public void rowPerPageTest() {
		UsersPage usersPage = dashboardPage.getNavigation().navigateToUserPages();
		printAllUserName(usersPage.getAllUserName());
		assertEquals(ROW_PER_PAGE, usersPage.getUserListSize(), "User per page number not valid");
		assertEquals(ROW_PER_PAGE, usersPage.getAllUserName().size(), "User per page not valid");
	}

	private void printAllUserName(List<WebElement> rows) {
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).findElement(By.xpath("/td[2]")).getText());
		}

	}
}
