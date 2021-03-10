package com.selenium.demo.toolsqa.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import com.selenium.demo.testbase.ToolsQATestBase;
import com.selenium.demo.toolsqa.pageobjects.NavigationPage;
import com.selenium.demo.toolsqa.pageobjects.dropabblepage.DroppablePage;
import com.selenium.demo.toolsqa.pageobjects.iteractionspage.InteractionsPage;

public class InteractionsTests extends ToolsQATestBase {

	private static final String DROPPED_VALUE = "Dropped!";
	private static final String DROPPED_SQUARE_BACKGROUND_COLOR = "70, 130, 180";

	InteractionsPage interactionsPage;

	@BeforeEach
	public void beforeTest() {
		final NavigationPage navigationPage = navigateToToolsQAPage();
		interactionsPage = navigationPage.navigateToInteractionsPage();
	}

	@Test
	public void droppableTest() {
		final DroppablePage droppablePage = interactionsPage.getDroppablePage();
		final Actions dragAndDrop = new Actions(getDriver());

		dragAndDrop.dragAndDrop(droppablePage.getDragabbleComponent(), droppablePage.getDropableleSquareComponent())
				.build().perform();

		assertEquals(DROPPED_VALUE, droppablePage.getDroppableSquareComponentText(),
				"Dragable component did not dropped.");
		assertTrue(droppablePage.getDroppableSquareComponentBackgroundValue().contains(DROPPED_SQUARE_BACKGROUND_COLOR),
				"Dragable component did not dropped, bacause background-color value: ");
	}

}
