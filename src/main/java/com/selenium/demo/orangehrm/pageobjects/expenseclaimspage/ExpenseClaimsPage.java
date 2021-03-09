package com.selenium.demo.orangehrm.pageobjects.expenseclaimspage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

public class ExpenseClaimsPage extends AbstractOrangeHrmPage {

	@FindBy(id = "claimRequestList")
	private WebElement resultsTable;

	@FindBy(css = "tr.dataRaw")
	private List<WebElement> tableResultRows;

	@FindBy(id = "noncoreIframe")
	private WebElement iframeContent;

	@FindBy(id = "frmList_ohrmListComponenttotal")
	private WebElement totalListElementInCurrentPage;

	public ExpenseClaimsPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();

		driver.switchTo().frame(iframeContent);

		final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

		waitForElementToAppear.apply(resultsTable);
		waitForElementToAppear.apply(totalListElementInCurrentPage);
	}

	public List<WebElement> getTableResultRows() {
		return tableResultRows;
	}

	public String getTotalListElementInCurrentPage() {
		return totalListElementInCurrentPage.getText();
	}
}
