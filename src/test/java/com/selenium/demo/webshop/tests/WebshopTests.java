package com.selenium.demo.webshop.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.screenshot.Screenshot;
import com.selenium.demo.testbase.WebShopTestBase;
import com.selenium.demo.webshop.pageobjects.homepage.HomePage;
import com.selenium.demo.webshop.pageobjects.quickview.QuickViewDialogBox;
import com.selenium.demo.webshop.pageobjects.searchpage.SearchPage;

public class WebshopTests extends WebShopTestBase {
	
	private static final String SEARCH_VALUE = "blouse";
	private static final String BLOUSE_DESCRIPTION = "Short sleeved blouse with feminine draped sleeve detail.";
	
	private HomePage homePage;

	@BeforeEach
	public void beforePTest() {
		homePage = navigateToWebShopPage();
	}

	@Test
	public void createScreenShotTest() {
		new Screenshot().createScreenShotByElement(homePage.getGirlInTheRedDress());
	}
	
	@Test
	public void searchTest() throws InterruptedException {
		final SearchPage searchPage = homePage.getNavigationBar().fillInputFieldAndSearch(SEARCH_VALUE);
		final QuickViewDialogBox quickViewDialogBox = searchPage.clickFirstElement();
		
		assertEquals(quickViewDialogBox.getDescriptionText(), BLOUSE_DESCRIPTION, "The description does not match");
	}

}
