package com.selenium.demo.webshop.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selenium.demo.testbase.WebShopTestBase;
import com.selenium.demo.webshop.enums.ColorEnum;
import com.selenium.demo.webshop.enums.SizeEnum;
import com.selenium.demo.webshop.pageobjects.fadedshortpage.AddCartDialogBox;
import com.selenium.demo.webshop.pageobjects.fadedshortpage.FadedShortPage;
import com.selenium.demo.webshop.pageobjects.homepage.HomePage;
import com.selenium.demo.webshop.pageobjects.navigationbar.NavigationBar;
import com.selenium.demo.webshop.pageobjects.orderpage.OrderPage;
import com.selenium.demo.webshop.pageobjects.quickview.QuickViewDialogBox;
import com.selenium.demo.webshop.pageobjects.searchpage.SearchPage;
import com.selenium.demo.webshop.pageobjects.signin.SignInPage;
import com.selenium.demo.webshop.pageobjects.tshirtpage.TShirtsPage;

public class WebshopTests extends WebShopTestBase {
	private static final String SCRENSHOOT_NAME = "redDress";
	
	private static final String SEARCH_VALUE = "blouse";
	private static final String BLOUSE_DESCRIPTION = "Short sleeved blouse with feminine draped sleeve detail.";
	
	private static final String ADD_CART_PRODUCT_TITLE_TEXT = "Faded Short Sleeve T-shirts";
	private static final String ADD_CART_COLOR_AND_SIZE = "Blue, M";
	
	private static final String TOTAL_PRODUCT = "$33.02";
	private static final String TOTAL_SHIPPING = "$2.00";
	private static final String TOTAL_TAX = "$0.00";
	private static final String TOTAL_PRICE = "$35.02";
	
	private static final String HEADER = "AUTHENTICATION";
	private static final String CURRENT_STEP = "02. Sign in";
	
	private HomePage homePage;

	@BeforeEach
	public void beforePTest() {
		homePage = navigateToWebShopPage();
	}

	@Test
	public void createScreenShotTest() {
		createScreenShotByElement(homePage.getGirlInTheRedDress(), SCRENSHOOT_NAME);
	}
	
	@Test
	public void searchTest() throws InterruptedException {
		final SearchPage searchPage = homePage.getNavigationBar().fillInputFieldAndSearch(SEARCH_VALUE);
		final QuickViewDialogBox quickViewDialogBox = searchPage.clickFirstElement();
		
		assertEquals(quickViewDialogBox.getDescriptionText(), BLOUSE_DESCRIPTION, "The description does not match");
	}

	@Test
	public void OrderTest() {
		final TShirtsPage tshirtPage = homePage.getNavigationBar().hoverAndClickTshirtsButton();
		FadedShortPage fadedShortPage = tshirtPage.clickFadedShortItem();
		fadedShortPage.increaseQuantityNumber();
		fadedShortPage.selectSize(SizeEnum.M);
		fadedShortPage.selectColor(ColorEnum.BLUE);
		final AddCartDialogBox addCartDialogBox = fadedShortPage.clickAddCartButton();

		assertEquals(ADD_CART_PRODUCT_TITLE_TEXT, addCartDialogBox.getProductTitleText(), "The title does not match");
		assertEquals(ADD_CART_COLOR_AND_SIZE, addCartDialogBox.getColorAndSizeText(), "The color or size does not match");
		
		final OrderPage orderPage = addCartDialogBox.clickProceedToCheckoutButton();
		
		assertEquals(TOTAL_PRODUCT, orderPage.getTotalProductText(), "Total product does not match");
		assertEquals(TOTAL_SHIPPING, orderPage.getTotalShippingText(), "Total shipping does not match");
		assertEquals(TOTAL_TAX, orderPage.getTotalTaxText(), "Total tax does not match");
		assertEquals(TOTAL_PRICE, orderPage.getTotalPriceText(), "Total price does not match");
		
		final SignInPage signInPage = orderPage.clickProceedToCheckoutButton();
		
		assertEquals(HEADER, signInPage.getHeadText(), "Head text does not match");
		assertEquals(CURRENT_STEP, signInPage.getCurrentStepText(), "Current Step text does not match");
		
	}
}
