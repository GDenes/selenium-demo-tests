package com.selenium.demo.testbase.driver.config;

import com.microsoft.edge.seleniumtools.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeConfig extends GenericConfig {

    protected static final Logger logger = LoggerFactory.getLogger(EdgeConfig.class);

    public EdgeOptions getOptions() {
        final EdgeOptions options = new EdgeOptions();
        options.addArguments("disable-gpu");

        return options;
    }
}
