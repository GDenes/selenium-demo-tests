package com.selenium.demo.testbase.drivers;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.selenium.demo.testbase.driver.config.EdgeConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeFactory extends GenericFactory implements DriverInterface {

    @Override
    public WebDriver getDriver() {
        logger.trace("Initializing local edge driver...");
        WebDriverManager.edgedriver().setup();

        EdgeDriver driver = new EdgeDriver(new EdgeConfig().getOptions());
        maximize(driver);

        logger.trace("Local edge driver initialized.");

        return driver;
    }

    @Override
    public WebDriver getRemoteWebDriver(String remoteUrl) {
        logger.trace("Initializing remote edge driver...");
        final WebDriver driver =  RemoteWebDriver.builder()
                .addAlternative(new EdgeConfig().getOptions())
                .url(remoteUrl)
                .build();
        maximize(driver);

        logger.trace("Remote edge driver initialized.");

        return driver;
    }
}
