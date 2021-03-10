package com.selenium.demo.toolsqa.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.testbase.ToolsQATestBase;
import com.selenium.demo.toolsqa.pageobjects.NavigationPage;
import com.selenium.demo.toolsqa.pageobjects.tooltipspage.ToolTipsPage;
import com.selenium.demo.toolsqa.pageobjects.widgetspage.WidgetsPage;

public class WidgetTests extends ToolsQATestBase {
	
	private static final String BUTTON_TOOL_TIP_TEXT = "You hovered over the Button";
	private static final String TEXT_FIELD_TOOL_TIP_TEXT = "You hovered over the text field";
	
	private WidgetsPage widgetsPage;
	
	@BeforeEach
	public void beforeTest() {
		final NavigationPage navigationPage = navigateToToolsQAPage();
		widgetsPage = navigationPage.navigateToWidgetsPage();
	}
	
	@Test
	public void toolTipTest() {
		final ToolTipsPage toolTipsPage = widgetsPage.navigateToToolTipsPage();

		assertEquals(BUTTON_TOOL_TIP_TEXT, toolTipsPage.hoverToolTipButtonAndGetText(), "The tooltip did not appear");
		assertEquals(TEXT_FIELD_TOOL_TIP_TEXT, toolTipsPage.hoverToolTipTextFieldAndGetText(), "The tooltip did not appear");
	}

}
