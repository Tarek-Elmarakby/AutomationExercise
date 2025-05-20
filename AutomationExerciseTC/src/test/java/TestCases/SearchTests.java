package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test(priority = 1)
    public void TC09SearchProduct() {
        homePage.clickProducts();
        productsPage.searchForProduct("Jeans");
        Assert.assertTrue(productsPage.verifySearchedProductsTitleIsVisible());
        Assert.assertTrue(productsPage.verifyProductResultsAreRelatedToSearch("Jeans"));
    }

    @Test(priority = 2)
    public void TC20SearchProductsAndVerifyCartAfterLogin() {
        homePage.clickProducts();
        productsPage.searchForProduct("tshirt");
        Assert.assertTrue(productsPage.verifySearchedProductsTitleIsVisible());
        Assert.assertTrue(productsPage.verifyProductResultsAreRelatedToSearch("shirt"));
        productsPage.addProductToCart(1, 3);
        productsPage.clickContinueShoppingButton();
        productsPage.addProductToCart(0, 1);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyCartItemsAreDisplayed(2));
        homePage.clickSignupLogin();
        loginPage.validLogin();
        homePage.clickCart();
        Assert.assertTrue(cartPage.verifyCartItemsAreDisplayed(2));
        cartPage.removeProductFromCart(0);
        cartPage.removeProductFromCart(1);
    }
}