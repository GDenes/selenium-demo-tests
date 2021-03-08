package com.selenium.demo.orangehrm.pageobjects.myinfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class MyInfoPage extends AbstractOrangeHrmPage {

	@FindBy(id = "personal_details_tab")
	private WebElement pesonalDeatilsTable;
	
	@FindBy(id = "firstName")
	private WebElement firstNameField;
	
	@FindBy(id = "middleName")
	private WebElement middleName;
	
	@FindBy(id = "lastName")
	private WebElement lastNameField;

	@FindBy(id = "employeeId")
	private WebElement employeeIdField;
	
	@FindBy(id = "otherId")
	private WebElement otherId;
	
	@FindBy(id = "emp_birthday")
	private WebElement empBirthdayField;
	
	@FindBy(css = "#emp_marital_status_inputfileddiv > div > input.select-dropdown")
	private WebElement empMaritalStatusField;
	
	@FindBy(css = "#emp_gender_inputfileddiv > div > input.select-dropdown")
	private WebElement empGenderField;
	
	@FindBy(css = "#nation_code_inputfileddiv > div > input.select-dropdown")
	private WebElement nationalityCodeInput;
	
	@FindBy(id = "licenseNo")
	private WebElement driverLicenseNoField;
	
	@FindBy(id = "emp_dri_lice_exp_date")
	private WebElement driverLicenseExpDateField;
	
	@FindBy(id = "nickName")
	private WebElement nickNameField;
	
	@FindBy(id = "militaryService")
	private WebElement militaryServiceField;
	
	
	public MyInfoPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		new WaitForElementToAppear(driver).apply(pesonalDeatilsTable);
		new WaitForElementToAppear(driver).apply(firstNameField);
	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getEmployeeIdField() {
		return employeeIdField;
	}

	public WebElement getOtherId() {
		return otherId;
	}

	public WebElement getEmpBirthdayField() {
		return empBirthdayField;
	}

	public WebElement getEmpMaritalStatusField() {
		return empMaritalStatusField;
	}

	public WebElement getEmpGenderField() {
		return empGenderField;
	}

	public WebElement getNationalityCodeInput() {
		return nationalityCodeInput;
	}

	public WebElement getDriverLicenseNoField() {
		return driverLicenseNoField;
	}

	public WebElement getDriverLicenseExpDateField() {
		return driverLicenseExpDateField;
	}

	public WebElement getNickNameField() {
		return nickNameField;
	}

	public WebElement getMilitaryServiceField() {
		return militaryServiceField;
	}
	
}
