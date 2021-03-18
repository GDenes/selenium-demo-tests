package com.selenium.demo.testbase.driver.config;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeConfig extends GenericConfig {

    protected static final Logger logger = LoggerFactory.getLogger(ChromeConfig.class);

    public EdgeOptions getOptions() {
        final EdgeOptions options = new EdgeOptions();
        options.setCapability("UseChromium", true);

        return options;
    }
}
