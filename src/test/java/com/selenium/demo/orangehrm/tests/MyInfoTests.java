package com.selenium.demo.orangehrm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.orangehrm.pageobjects.dashboardpage.DashboardPage;
import com.selenium.demo.orangehrm.pageobjects.loginpage.LoginPage;
import com.selenium.demo.orangehrm.pageobjects.myinfo.MyInfoPage;
import com.selenium.demo.testbase.OrangeHrmTestBase;

public class MyInfoTests extends OrangeHrmTestBase {
	
	//Login credentials
	private static final String SIMPLE_USER_USERNAME = "linda";
	private static final String SIMPLE_USER_PASSWORD = "linda.anderson";
	
	// Test data
	private static final String FIRST_NAME = "Linda";
	private static final String MIDDLE_NAME = "Jane";
	private static final String LAST_NAME = "Anderson";
	private static final String EMPLOYEE_ID = "1000";
	private static final String DATE_OF_BIRTH = "Wed, 05 Jun 1985";
	private static final String MARTIAL_STATUS = "Married";
	private static final String GENDER = "Female";
	private static final String NATIONALITY = "Canadian";
	private static final String DRIVER_LICENS_EXP_DATE = "Fri, 06 Mar 2020";
	
	 MyInfoPage myInfoPage;
	
	@BeforeEach
	public void beforeTest() {
		final LoginPage loginPage = navigateToOrangeHrmPage();
		DashboardPage dashboardPage = loginPage.loginWithCredential(SIMPLE_USER_USERNAME, SIMPLE_USER_PASSWORD);
		myInfoPage = dashboardPage.getUserNavigation().navigateToMyInfoPage();
	}

	@Test
	public void myInfoTest() {
		assertEquals(FIRST_NAME, myInfoPage.getFirstNameField().getAttribute("value"), "First name value is not valid.");
		assertEquals(MIDDLE_NAME, myInfoPage.getMiddleName().getAttribute("value"), "Middle name value is not valid.");
		assertEquals(LAST_NAME, myInfoPage.getLastNameField().getAttribute("value"), "Last name value is not valid.");
		assertEquals(EMPLOYEE_ID, myInfoPage.getEmployeeIdField().getAttribute("value"), "Employe Id is not valid.");
		assertEquals(DATE_OF_BIRTH, myInfoPage.getEmpBirthdayField().getAttribute("value"), "Date of birth is not valid.");
		assertEquals(MARTIAL_STATUS, myInfoPage.getEmpMaritalStatusField().getAttribute("value"), "Martial Status is not valid.");
		assertEquals(GENDER, myInfoPage.getEmpGenderField().getAttribute("value"), "Gender is not valid.");
		assertEquals(NATIONALITY, myInfoPage.getNationalityCodeInput().getAttribute("value"), "Nationality is not valid.");
		assertEquals(DRIVER_LICENS_EXP_DATE, myInfoPage.getDriverLicenseExpDateField().getAttribute("value"), "Driver licens exp date value is not valid.");
	}
	
}
