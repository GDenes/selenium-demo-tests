package com.selenium.demo.orangehrm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;
import com.selenium.demo.orangehrm.pageobjects.userpage.UsersPage;
import com.selenium.demo.testbase.OrangeHrmTestBase;

public class UserLIstTests extends OrangeHrmTestBase {

	private static final String SYS_ADMIN_USERNAME = "_ohrmSysAdmin_";
	private static final String SYS_ADMIN_PASSWORD = "sysadmin";

	private static final String USERNAME_VALUE_FROM_TABLE = "span";

	private static final int ROW_PER_PAGE = 50;

	DashboardPage dashboardPage;

	@BeforeEach
	public void beforeTest() {
		final LoginPage loginPage = navigateToOrangeHrmPage();
		dashboardPage = loginPage.loginWithCredential(SYS_ADMIN_USERNAME, SYS_ADMIN_PASSWORD);
	}

	@Test
	public void rowPerPageTest() {
		UsersPage usersPage = dashboardPage.getAdminNavigation().navigateToUserPages();

		assertEquals(ROW_PER_PAGE, usersPage.getUserListSize(), "User per page number not valid");
		assertEquals(ROW_PER_PAGE, usersPage.getAllUserName().size(), "User per page not valid");
		printAllUserNameToTerminal(usersPage.getAllUserName(), USERNAME_VALUE_FROM_TABLE);
	}

}
