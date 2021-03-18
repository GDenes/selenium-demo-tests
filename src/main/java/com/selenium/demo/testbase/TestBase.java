package com.selenium.demo.testbase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.selenium.demo.testbase.drivers.DriverFactory;

public abstract class TestBase {

    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    private static final String REMOTE_IP_PARAMETER_NAME = "remoteIp";

    protected static final BrowsersEnum browser = BrowsersEnum.CHROME_HEADLESS;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        final String remoteIpString = getParameter(REMOTE_IP_PARAMETER_NAME);
        if (remoteIpString != null) {
            driver = new DriverFactory().createRemoteDriver(browser, remoteIpString);
        } else {
            driver = new DriverFactory().createDriver(browser);
        }
    }

    @AfterEach
    public void afterClass() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static BrowsersEnum getBrowser() {
        return browser;
    }

    private String getParameter(final String parameterName) {
        return System.getProperty(parameterName);
    }
}
