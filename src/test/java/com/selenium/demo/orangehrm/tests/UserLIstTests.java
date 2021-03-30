package com.selenium.demo.orangehrm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.orangehrm.enums.PageEnum;
import com.selenium.demo.orangehrm.enums.UserEnum;
import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;
import com.selenium.demo.orangehrm.pageobjects.userpage.UsersPage;
import com.selenium.demo.testbase.OrangeHrmTestBase;

public class UserLIstTests extends OrangeHrmTestBase {

	private static final String USERNAME_VALUE_FROM_TABLE = "span";

	private static final int ROW_PER_PAGE = 50;

	DashboardPage dashboardPage;

	@BeforeEach
	public void beforeTest() {
		final LoginPage loginPage = navigateToOrangeHrmPage();
		dashboardPage = loginPage.login(UserEnum.SYSTEM_ADMIN);
	}

	@Test
	public void rowPerPageTest() {
		final UsersPage usersPage = (UsersPage) dashboardPage.navigateTo(PageEnum.USER_PAGE);

		printAllUserNameToTerminal(usersPage.getAllUserName(), USERNAME_VALUE_FROM_TABLE);
		
		assertEquals(ROW_PER_PAGE, usersPage.getUserListSize(), "User per page number not valid");
		assertEquals(ROW_PER_PAGE, usersPage.getAllUserName().size(), "User per page not valid");
	}

}
