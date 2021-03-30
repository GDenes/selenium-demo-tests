package com.selenium.demo.orangehrm.pageobjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.demo.orangehrm.enums.PageEnum;
import com.selenium.demo.orangehrm.enums.UserEnum;
import com.selenium.demo.orangehrm.pageobjects.common.AbstractOrangeHrmPage;
import com.selenium.demo.orangehrm.pageobjects.expenseclaimspage.ExpenseClaimsPage;
import com.selenium.demo.orangehrm.pageobjects.myinfo.MyInfoPage;
import com.selenium.demo.testbase.BrowsersEnum;
import com.selenium.demo.wait.WaitForElementToAppear;

import static org.junit.jupiter.api.Assertions.fail;

public class UserNavigationLeftSideBar extends AbstractNavigationLeftSideBar {

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoMenuItem;

    public UserNavigationLeftSideBar(WebDriver driver, BrowsersEnum browser) {
        super(driver, browser);
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();

        new WaitForElementToAppear(driver).apply(myInfoMenuItem);
    }

    @Override
    public AbstractOrangeHrmPage navigateTo(PageEnum pageEnum) {
        switch (pageEnum) {
            case MY_INFO_PAGE:
                return navigateToMyInfoPage();
            case EXPENSE_CLAIMS_PAGE:
                return navigateToExpenseClaimsPage();
        }
        return fail("Page not implemented!");
    }

    @Override
	public ExpenseClaimsPage navigateToExpenseClaimsPage() {
        final WaitForElementToAppear waitForElementToAppear = new WaitForElementToAppear(driver);

        expenseMenuItem.click();
        waitForElementToAppear.apply(claimsSubMenuItem);
        claimsSubMenuItem.click();
        waitForElementToAppear.apply(underClaimsEmployeeSubMenuItem);
        underClaimsEmployeeSubMenuItem.click();

        return new ExpenseClaimsPage(driver, browser, UserEnum.ESS_USER);
    }

    private MyInfoPage navigateToMyInfoPage() {
        myInfoMenuItem.click();
        return new MyInfoPage(driver, browser, UserEnum.ESS_USER);
    }

}
