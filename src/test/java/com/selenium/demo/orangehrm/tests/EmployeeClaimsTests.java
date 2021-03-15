package com.selenium.demo.orangehrm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.orangehrm.pageobjects.expenseclaimspage.ExpenseClaimsPage;
import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;
import com.selenium.demo.testbase.OrangeHrmTestBase;

public class EmployeeClaimsTests extends OrangeHrmTestBase {
	
	private static final String EXPENSE_CLAIMS_ID_TAG_NAME = "a";

	ExpenseClaimsPage expenseClaimsPage;
	
	@BeforeEach
	public void beforeTest() {
		final LoginPage loginPage = navigateToOrangeHrmPage();
		final DashboardPage dashboardPage = loginPage.loginWithCredential(SYS_ADMIN_USERNAME, SYS_ADMIN_PASSWORD);
		expenseClaimsPage = dashboardPage.getAdminNavigation().navigateToExpenseClaimsPage();
	}
	
	@Test
	public void expenseClaimsTest() {
		int size = Integer.parseInt(expenseClaimsPage.getTotalListElementInCurrentPage());
		printAllUserNameToTerminal(expenseClaimsPage.getTableResultRows(), EXPENSE_CLAIMS_ID_TAG_NAME);
		assertEquals(size, expenseClaimsPage.getTableResultRows().size());
	}

}
