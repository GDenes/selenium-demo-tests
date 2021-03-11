package com.selenium.demo.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class Screenshot {
	private static final String SCREENSHOT_FILE_PATH = "screenshots";

	public Screenshot() {}

	public void createScreenShotByElement(WebElement element) {
		final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

		File screenShot = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(SCREENSHOT_FILE_PATH + File.separator + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
