package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test(priority = 1)
    public void TC01RegisterUser() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        Assert.assertTrue(signupPage.verifyNewUserSignupTitleIsVisible());
        signupPage.validSignup();
        Assert.assertTrue(signupPage.verifyEnterAccountInformationIsVisible());
        signupPage.completeSignupForm();
        Assert.assertTrue(signupPage.verifyAccountCreatedIsVisible());
        homePage.clickContinueButton();
        Assert.assertTrue(homePage.verifyLoggedInAsUsernameIsVisible());
        homePage.clickDeleteAccount();
        Assert.assertTrue(homePage.verifyAccountIsDeleted());
        homePage.clickContinueButton();
    }

    @Test(priority = 2)
    public void TC05RegisterUserWithExistingEmail() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        Assert.assertTrue(signupPage.verifyNewUserSignupTitleIsVisible());
        signupPage.inValidSignup();
        Assert.assertTrue(signupPage.verifySignupErrorMessageIsVisible());
    }
}
