package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OtherTests extends BaseTest {

    @Test(priority = 1)
    public void TC06ContactUsForm() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickContactUs();
        Assert.assertTrue(contactUsPage.verifyContactUsPageIsVisible());
        contactUsPage.fillContactForm();
        Assert.assertTrue(contactUsPage.verifySuccessMessageIsVisible());
        homePage.clickHome();
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
    }

    @Test(priority = 2)
    public void TC07VerifyTestCasesPage() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickTestCases();
        Assert.assertTrue(testCasesPage.verifyTestCasesPageIsVisible());
    }

    @Test(priority = 3)
    public void TC10VerifySubscriptionHomePage() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.scrollToSubscriptionFooter();
        Assert.assertTrue(homePage.verifySubscriptionFooterIsVisible());
        homePage.subscriptionByEmail();
        Assert.assertTrue(homePage.verifySubscriptionSuccessAlertIsVisible());
    }

    @Test(priority = 4)
    public void TC11VerifySubscriptionCartPage() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickCart();
        homePage.scrollToSubscriptionFooter();
        Assert.assertTrue(homePage.verifySubscriptionFooterIsVisible());
        homePage.subscriptionByEmail();
        Assert.assertTrue(homePage.verifySubscriptionSuccessAlertIsVisible());
    }

    @Test(priority = 5)
    public void TC25VerifyScrollUpWithArrow() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.scrollToSubscriptionFooter();
        Assert.assertTrue(homePage.verifySubscriptionFooterIsVisible());
        homePage.clickScrollUpArrow();
        Assert.assertTrue(homePage.verifyFirstFullFledgedHeadingIsVisible());
    }

    @Test(priority = 6)
    public void TC26VerifyScrollUpWithoutArrow() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.scrollToSubscriptionFooter();
        Assert.assertTrue(homePage.verifySubscriptionFooterIsVisible());
        Assert.assertTrue(homePage.verifyFirstFullFledgedHeadingIsVisible());
    }
}
