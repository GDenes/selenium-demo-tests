package com.selenium.demo.orangehrm.pageobjects.common;

import org.openqa.selenium.WebDriver;

import com.selenium.demo.orangehrm.enums.PageEnum;
import com.selenium.demo.orangehrm.enums.UserEnum;
import com.selenium.demo.orangehrm.pageobjects.navigation.AbstractNavigationLeftSideBar;
import com.selenium.demo.orangehrm.pageobjects.navigation.AdminNavigationLeftSideBar;
import com.selenium.demo.orangehrm.pageobjects.navigation.UserNavigationLeftSideBar;
import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;

import static org.junit.jupiter.api.Assertions.fail;

public class AbstractOrangeHrmPage extends AbstractPage {

    AbstractNavigationLeftSideBar navigation;

    public AbstractOrangeHrmPage(WebDriver driver, BrowsersEnum browser) {
        super(driver, browser);
    }

    public AbstractOrangeHrmPage(WebDriver driver, BrowsersEnum browser, UserEnum userEnum) {
        super(driver, browser);
        switch (userEnum) {
            case ESS_USER:
                navigation = new UserNavigationLeftSideBar(driver, browser);
                break;
            case SYSTEM_ADMIN:
                navigation = new AdminNavigationLeftSideBar(driver, browser);
                break;
            default: fail("This user not implemented!");
        }
    }
    public AbstractOrangeHrmPage navigateTo(PageEnum pageEnum) {
        return navigation.navigateTo(pageEnum);
    }
}
