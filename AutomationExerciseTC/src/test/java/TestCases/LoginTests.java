package TestCases;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void TC02LoginUserWithCorrectEmailAndPassword() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.verifyLoginToAccountTitleIsVisible());
        loginPage.validLogin();
        Assert.assertTrue(homePage.verifyLoggedInAsUsernameIsVisible());
    }

    @Test(priority = 2)
    public void TC03LoginUserWithIncorrectEmailAndPassword() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.verifyLoginToAccountTitleIsVisible());
        loginPage.inValidLogin();
        Assert.assertTrue(loginPage.verifyLoginErrorMessageIsVisible());
    }

    @Test(priority = 3)
    public void TC04LogoutUser() {
        Assert.assertTrue(homePage.verifyHomePageIsVisible());
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.verifyLoginToAccountTitleIsVisible());
        loginPage.validLogin();
        Assert.assertTrue(homePage.verifyLoggedInAsUsernameIsVisible());
        homePage.clickLogout();
        Assert.assertTrue(loginPage.verifyLoginToAccountTitleIsVisible());
    }
}
