package com.selenium.demo.toolsqa.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.testbase.ToolsQATestBase;
import com.selenium.demo.toolsqa.pageobjects.NavigationPage;
import com.selenium.demo.toolsqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage;
import com.selenium.demo.toolsqa.pageobjects.elementspage.ElementsPage;

public class ElementsTests extends ToolsQATestBase{
	private ElementsPage elementsPage;
	@BeforeEach
	public void beforeTest() {
		final NavigationPage navigationPage = navigateToToolsQAPage();
		elementsPage =navigationPage.navigateToElementsPage();
	}
	
	@Test
	public void DynamicPropertiesTest() {
	 DynamicPropertiesPage dynamicPropertiesPage = elementsPage.navigateToDynamicPropertiesPage();
	 
	 assertTrue(dynamicPropertiesPage.willEnabledButton(), "Button is not enabled");
	 assertTrue(dynamicPropertiesPage.colorChangedButton(), "The color of the button text has not changed");
	 assertTrue(dynamicPropertiesPage.visibledButton(), "The button is not visible");
	}

}
