package com.selenium.demo.webshop.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.selenium.demo.testbase.WebShopTestBase;
import com.selenium.demo.webshop.enums.ColorEnum;
import com.selenium.demo.webshop.enums.SizeEnum;
import com.selenium.demo.webshop.pageobjects.fadedshortpage.AddCartDialogBox;
import com.selenium.demo.webshop.pageobjects.fadedshortpage.FadedShortPage;
import com.selenium.demo.webshop.pageobjects.homepage.HomePage;
import com.selenium.demo.webshop.pageobjects.orderpage.OrderPage;
import com.selenium.demo.webshop.pageobjects.signin.SignInPage;
import com.selenium.demo.webshop.pageobjects.tshirtpage.TShirtsPage;

public class OrderTests extends WebShopTestBase {

	private static final String ADD_CART_PRODUCT_TITLE_TEXT = "Faded Short Sleeve T-shirts";
	private static final String ADD_CART_COLOR_AND_SIZE_01 = "Blue, M";
	private static final String ADD_CART_COLOR_AND_SIZE_02 = "Orange, S";

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
		getDriver().manage().deleteAllCookies();
	}

	@DisplayName("Parametrized order tests")
	@ParameterizedTest(name = "{index}: ({0} + {1}) => {2})")
	@MethodSource("orderTestParamaters")
	public void OrderTest(SizeEnum size, ColorEnum color, final String expectedAddedColorAndSize) {
		final TShirtsPage tshirtPage = homePage.getNavigationBar().hoverAndClickTshirtsButton();
		
		FadedShortPage fadedShortPage = tshirtPage.clickFadedShortItem();
		fadedShortPage.increaseQuantityNumber();
		fadedShortPage.selectSize(size);
		fadedShortPage.selectColor(color);
		
		final AddCartDialogBox addCartDialogBox = fadedShortPage.clickAddCartButton();

		assertEquals(ADD_CART_PRODUCT_TITLE_TEXT, addCartDialogBox.getProductTitleText(), "The title does not match");
		assertEquals(expectedAddedColorAndSize, addCartDialogBox.getColorAndSizeText(),
				"The color or size does not match");

		final OrderPage orderPage = addCartDialogBox.clickProceedToCheckoutButton();

		assertEquals(TOTAL_PRODUCT, orderPage.getTotalProductText(), "Total product does not match");
		assertEquals(TOTAL_SHIPPING, orderPage.getTotalShippingText(), "Total shipping does not match");
		assertEquals(TOTAL_TAX, orderPage.getTotalTaxText(), "Total tax does not match");
		assertEquals(TOTAL_PRICE, orderPage.getTotalPriceText(), "Total price does not match");

		final SignInPage signInPage = orderPage.clickProceedToCheckoutButton();

		assertEquals(HEADER, signInPage.getHeadText(), "Head text does not match");
		assertEquals(CURRENT_STEP, signInPage.getCurrentStepText(), "Current Step text does not match");
	}

	static Stream<Arguments> orderTestParamaters() {
		return Stream.of(
				Arguments.of(SizeEnum.M, ColorEnum.BLUE, ADD_CART_COLOR_AND_SIZE_01),
				Arguments.of(SizeEnum.S, ColorEnum.ORANGE, ADD_CART_COLOR_AND_SIZE_02));
	}

}
