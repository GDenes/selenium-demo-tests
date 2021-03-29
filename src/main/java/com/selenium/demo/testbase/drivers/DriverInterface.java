package com.selenium.demo.testbase.drivers;

import org.openqa.selenium.WebDriver;

public interface DriverInterface {
  WebDriver getDriver();
  WebDriver getRemoteWebDriver(String remoteUrl);
}