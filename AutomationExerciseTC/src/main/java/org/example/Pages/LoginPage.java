package org.example.Pages;

import org.example.BasePage.BasePage;
import org.example.Credentials.AuthCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "div.login-form h2")
    private WebElement loginToAccountTitle;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "form[action='/login'] p")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void validLogin() {
        type(loginEmailInput, AuthCredentials.RegisteredEmail);
        type(loginPasswordInput, AuthCredentials.RegisteredPassword);
        click(loginButton);
    }

    public void inValidLogin() {
        type(loginEmailInput, AuthCredentials.InvalidEmail);
        type(loginPasswordInput, AuthCredentials.InvalidPassword);
        click(loginButton);
    }

    public boolean verifyLoginToAccountTitleIsVisible() {
        return isVisible(loginToAccountTitle)
                && loginToAccountTitle.getText().equalsIgnoreCase(
                "Login to your account");
    }

    public boolean verifyLoginErrorMessageIsVisible() {
        return isVisible(loginErrorMessage)
                && loginErrorMessage.getText().equalsIgnoreCase(
                "Your email or password is incorrect!");
    }
}