package com.selenium.demo.testbase.drivers;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import com.selenium.demo.testbase.driver.config.EdgeConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeHeadlessFactory extends GenericFactory implements DriverInterface {

    @Override
    public WebDriver getDriver() {
        logger.trace("Initializing local edge driver...");

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeConfig().getOptions();
        options.addArguments("headless");

        EdgeDriver driver = new EdgeDriver(options);
        maximize(driver);
        logger.trace("Local edge driver initialized.");
        return driver;
    }

    @Override
    public WebDriver getRemoteWebDriver(String remoteUrl) {
        EdgeOptions options = new EdgeConfig().getOptions();
        options.addArguments("headless");

        final WebDriver driver =  RemoteWebDriver.builder()
                .addAlternative(options)
                .url(remoteUrl)
                .build();
        maximize(driver);

        return driver;
    }
}
