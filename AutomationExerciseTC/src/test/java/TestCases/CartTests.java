package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(priority = 1)
    public void TC12AddProductsInCart() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickProducts();
        productsPage.addProductToCart(2, 5);
        productsPage.clickContinueShoppingButton();
        productsPage.addProductToCart(1, 3);
        productsPage.clickViewCartButton();
        cartPage.verifyCartItemsAreDisplayed(2);
        cartPage.removeProductFromCart(0);
        cartPage.removeProductFromCart(1);
    }

    @Test(priority = 2)
    public void TC13VerifyProductQuantity() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        productsPage.clickViewProductLink(0);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.updateQuantity("4");
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyItemQuantityInCart(0, 4));
    }

    @Test(priority = 3)
    public void TC17RemoveProductsFromCart() {
        homePage.verifyHomePageIsVisible();
        productsPage.addProductToCart(0, 1);
        productsPage.clickViewCartButton();
        cartPage.verifyCartItemsAreDisplayed(1);
        cartPage.removeProductFromCart(0);
        Assert.assertTrue(cartPage.verifyEmptyCartMessageIsVisible());
    }

    @Test(priority = 4)
    public void TC22AddToCartFromRecommendedItems() {
        homePage.scrollToRecommendedItemsSection();
        Assert.assertTrue(homePage.verifyRecommendedItemsSectionIsVisible());
        homePage.addToCartFromRecommendedItems(0);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyCartItemsAreDisplayed(1));
    }
}
