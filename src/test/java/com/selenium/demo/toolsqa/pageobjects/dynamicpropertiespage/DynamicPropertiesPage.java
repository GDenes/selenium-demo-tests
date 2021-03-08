package com.selenium.demo.toolsqa.pageobjects.dynamicpropertiespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.demo.pageobjects.common.AbstractPage;
import com.selenium.demo.testbase.BrowsersEnum;

public class DynamicPropertiesPage extends AbstractPage {

	private static final String DANGER_CLASS_NAME = "text-danger";
	private static final int WAIT = 6;

	@FindBy(css = "#enableAfter")
	private WebElement enableAfter;

	@FindBy(css = "#colorChange")
	private WebElement colorChange;

	@FindBy(css = "#visibleAfter")
	private WebElement visibleAfter;

	public DynamicPropertiesPage(WebDriver driver, BrowsersEnum browser) {
		super(driver, browser);
	}

	public Boolean willEnabledButton() {

		WebDriverWait wait = new WebDriverWait(driver, WAIT);
		WebElement willEnabledButton = wait.until(ExpectedConditions.elementToBeClickable(enableAfter));
		return willEnabledButton.isEnabled();

	}

	public Boolean colorChangedButton() {
		String className = colorChange.getAttribute("class");
		if (className.contains(DANGER_CLASS_NAME)) {
			return true;
		}
		return false;
	}
	
	public boolean visibledButton() {
		WebDriverWait wait = new WebDriverWait(driver, WAIT);
		return wait.until(ExpectedConditions.visibilityOf(visibleAfter)).isDisplayed();
	}

}
