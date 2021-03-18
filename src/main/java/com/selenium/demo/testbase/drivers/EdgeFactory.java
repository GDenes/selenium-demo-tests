package com.selenium.demo.testbase.drivers;

import com.selenium.demo.testbase.driver.config.EdgeConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;

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
}
