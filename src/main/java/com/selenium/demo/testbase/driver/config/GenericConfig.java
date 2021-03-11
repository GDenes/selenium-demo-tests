package com.selenium.demo.testbase.driver.config;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class GenericConfig {
	
	protected LoggingPreferences logTypes() {
		final List<String> logTypes = Collections.singletonList(LogType.BROWSER);

		LoggingPreferences logs = new LoggingPreferences();
		logTypes.forEach(logType -> logs.enable(logType, Level.ALL));

		return logs;
	}
}
