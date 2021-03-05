package com.selenium.demo.testbase.drivers;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface DriverInterface {
  WebDriver getDriver() throws MalformedURLException;
}