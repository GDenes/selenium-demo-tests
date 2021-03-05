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
import com.selenium.demo.webshop.pageobjects.tshirtpage.TShirtsPage;

public class WebshopTests extends WebShopTestBase {
	private static final String SCRENSHOOT_NAME = "redDress";
	private static final String ADD_CART_PRODUCT_TITLE_TEXT = "Faded Short Sleeve T-shirts";
	private static final String ADD_CART_COLOR_AND_SIZE = "Blue, S";
	private HomePage homePage;

	@BeforeEach
	public void beforePTest() {
		homePage = navigateToWebShopPage();
	}

	@Test
	public void createScreenShot() {
		createScreenShotByElement(homePage.getGirlInTheRedDress(), SCRENSHOOT_NAME);
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
		
	}
}
