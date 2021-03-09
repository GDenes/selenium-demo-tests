package com.selenium.demo.orangehrm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.orangehrm.pageobjects.expenseclaimspage.ExpenseClaimsPage;
import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;
import com.selenium.demo.testbase.OrangeHrmTestBase;

public class EmployeeClaimsTests extends OrangeHrmTestBase {

	private static final String SYS_ADMIN_USERNAME = "_ohrmSysAdmin_";
	private static final String SYS_ADMIN_PASSWORD = "sysadmin";
	
	private static final String EXPENSE_CLAIMS_ID_TAGNAME = "a";

	ExpenseClaimsPage expenseClaimsPage;
	
	@BeforeEach
	public void beforeTest() {
		final LoginPage loginPage = navigateToOrangeHrmPage();
		final DashboardPage dashboardPage = loginPage.loginWithCredential(SYS_ADMIN_USERNAME, SYS_ADMIN_PASSWORD);
		expenseClaimsPage = dashboardPage.getAdminNavigation().navigateToExponseClaimsPage();
	}
	
	@Test
	public void expenseClaimsTest() {
		int size = Integer.parseInt(expenseClaimsPage.getTotalListElementInCurrentPage().getText());
		printAllUserNameToTerminal(expenseClaimsPage.getTableResultRows(), EXPENSE_CLAIMS_ID_TAGNAME);
		assertEquals(size, expenseClaimsPage.getTableResultRows().size());
	}

}
