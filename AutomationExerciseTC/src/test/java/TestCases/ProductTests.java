package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(priority = 1)
    public void TC08VerifyAllProductsAndProductDetailPage() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickProducts();
        Assert.assertTrue(productsPage.verifyProductsHeaderTitleIsVisible("All Products"));
        Assert.assertTrue(productsPage.verifyProductsListAreVisible());
        productsPage.clickViewProductLink(0);
        Assert.assertTrue(productDetailPage.verifyProductDetailIsVisible());
    }

    @Test(priority = 2)
    public void TC18ViewCategoryProducts() {
        Assert.assertTrue(homePage.verifyCategoryHeaderIsVisible());
        homePage.clickMenTShirtsCategoryLink();
        Assert.assertTrue(productsPage.verifyProductsHeaderTitleIsVisible("Men - Tshirts Products"));
        homePage.clickKidsDressCategoryLink();
        Assert.assertTrue(productsPage.verifyProductsHeaderTitleIsVisible("KIDS -  DRESS PRODUCTS"));
    }

    @Test(priority = 3)
    public void TC19ViewCartBrandProducts() {
        homePage.clickProducts();
        Assert.assertTrue(productsPage.verifyBrandsSectionTitleIsVisible());
        productsPage.clickPoloBrandLink();
        Assert.assertTrue(productsPage.verifyProductsHeaderTitleIsVisible("Brand - Polo Products"));
        productsPage.clickMadameBrandLink();
        Assert.assertTrue(productsPage.verifyProductsHeaderTitleIsVisible("Brand - Madame Products"));
    }

    @Test(priority = 4)
    public void TC21AddReviewOnProduct() {
        homePage.clickProducts();
        Assert.assertTrue(productsPage.verifyProductsHeaderTitleIsVisible("All Products"));
        productsPage.clickViewProductLink(0);
        Assert.assertTrue(productDetailPage.verifyReviewHeaderIsVisible());
        productDetailPage.addReviewOnProduct();
        Assert.assertTrue(productDetailPage.verifyReviewSuccessMessage());
    }
}
