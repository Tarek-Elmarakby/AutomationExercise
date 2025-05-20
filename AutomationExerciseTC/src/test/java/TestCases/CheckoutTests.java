package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(priority = 1)
    public void TC14PlaceOrderRegisterWhileCheckout() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        productsPage.addProductToCart(0, 1);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyShoppingCartTitleIsDisplayed());
        cartPage.clickProceedToCheckout();
        checkoutPage.clickRegisterLoginLink();
        signupPage.validSignup();
        signupPage.completeSignupForm();
        Assert.assertTrue(signupPage.verifyAccountCreatedIsVisible());
        homePage.clickContinueButton();
        homePage.verifyLoggedInAsUsernameIsVisible();
        homePage.clickCart();
        Assert.assertTrue(cartPage.verifyShoppingCartTitleIsDisplayed());
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.verifyBillingAddressIsCorrect());
        Assert.assertTrue(checkoutPage.verifyDeliveryAddressIsCorrect());
        checkoutPage.enterCommentAndPlaceOrder();
        paymentPage.enterPaymentDetailsAndPay();
        Assert.assertTrue(paymentPage.verifyOrderConfirmationMessage());
        homePage.clickDeleteAccount();
        Assert.assertTrue(homePage.verifyAccountIsDeleted());
    }

    @Test(priority = 2)
    public void TC15PlaceOrderRegisterBeforeCheckout() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        signupPage.validSignup();
        signupPage.completeSignupForm();
        Assert.assertTrue(signupPage.verifyAccountCreatedIsVisible());
        homePage.clickContinueButton();
        homePage.verifyLoggedInAsUsernameIsVisible();
        productsPage.addProductToCart(1, 3);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyShoppingCartTitleIsDisplayed());
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.verifyBillingAddressIsCorrect());
        Assert.assertTrue(checkoutPage.verifyDeliveryAddressIsCorrect());
        checkoutPage.enterCommentAndPlaceOrder();
        paymentPage.enterPaymentDetailsAndPay();
        Assert.assertTrue(paymentPage.verifyOrderConfirmationMessage());
        homePage.clickDeleteAccount();
        Assert.assertTrue(homePage.verifyAccountIsDeleted());
    }

    @Test(priority = 3)
    public void TC16PlaceOrderLoginBeforeCheckout() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        loginPage.validLogin();
        homePage.verifyLoggedInAsUsernameIsVisible();
        productsPage.addProductToCart(1, 3);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyShoppingCartTitleIsDisplayed());
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.verifyBillingAddressIsCorrect());
        Assert.assertTrue(checkoutPage.verifyDeliveryAddressIsCorrect());
        checkoutPage.enterCommentAndPlaceOrder();
        paymentPage.enterPaymentDetailsAndPay();
        Assert.assertTrue(paymentPage.verifyOrderConfirmationMessage());
    }

    @Test(priority = 4)
    public void TC23VerifyAddressDetailsCheckout() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        signupPage.validSignup();
        signupPage.completeSignupForm();
        Assert.assertTrue(signupPage.verifyAccountCreatedIsVisible());
        homePage.clickContinueButton();
        homePage.verifyLoggedInAsUsernameIsVisible();
        productsPage.addProductToCart(1, 3);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyShoppingCartTitleIsDisplayed());
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.verifyBillingAddressIsCorrect());
        Assert.assertTrue(checkoutPage.verifyDeliveryAddressIsCorrect());
        homePage.clickDeleteAccount();
        Assert.assertTrue(homePage.verifyAccountIsDeleted());
    }

    @Test(priority = 5)
    public void TC24DownloadInvoiceAfterPurchase() throws InterruptedException {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        productsPage.addProductToCart(0, 1);
        productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyShoppingCartTitleIsDisplayed());
        cartPage.clickProceedToCheckout();
        checkoutPage.clickRegisterLoginLink();
        signupPage.validSignup();
        signupPage.completeSignupForm();
        Assert.assertTrue(signupPage.verifyAccountCreatedIsVisible());
        homePage.clickContinueButton();
        homePage.verifyLoggedInAsUsernameIsVisible();
        homePage.clickCart();
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.verifyBillingAddressIsCorrect());
        Assert.assertTrue(checkoutPage.verifyDeliveryAddressIsCorrect());
        checkoutPage.enterCommentAndPlaceOrder();
        paymentPage.enterPaymentDetailsAndPay();
        Assert.assertTrue(paymentPage.verifyOrderConfirmationMessage());
        paymentPage.downloadInvoice();
        Assert.assertTrue(fileDownloader.isFileDownloaded("invoice", 10));
        homePage.clickContinueButton();
        homePage.clickDeleteAccount();
        Assert.assertTrue(homePage.verifyAccountIsDeleted());
    }
}
