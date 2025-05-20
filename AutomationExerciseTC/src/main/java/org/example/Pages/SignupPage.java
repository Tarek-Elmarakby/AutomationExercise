package org.example.Pages;

import org.example.BasePage.BasePage;
import org.example.Credentials.AuthCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(css = "div.signup-form h2")
    private WebElement newUserSignupTitle;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "form[action='/signup'] p")
    private WebElement signupErrorMessage;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//h2/b[contains(text(),'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(xpath = "//h2/b[contains(text(),'Account Created!')]")
    private WebElement accountCreated;

    // Account Information
    @FindBy(css = "input#id_gender1")
    private WebElement genderMr;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    // Address Information
    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void validSignup() {
        type(signupNameInput, AuthCredentials.Name);
        type(signupEmailInput, AuthCredentials.Email);
        click(signupButton);
    }

    public void completeSignupForm() {
        // Account Information
        click(genderMr);
        type(passwordInput, AuthCredentials.Password);
        selectDropdownByValue(daysDropdown, AuthCredentials.BirthDay);
        selectDropdownByVisibleText(monthsDropdown, AuthCredentials.BirthMonth);
        selectDropdownByValue(yearsDropdown, AuthCredentials.BirthYear);
        click(newsletterCheckbox);
        click(specialOffersCheckbox);

        // Address Information
        type(firstNameInput, AuthCredentials.FirstName);
        type(lastNameInput, AuthCredentials.LastName);
        type(companyInput, AuthCredentials.Company);
        type(address1Input, AuthCredentials.Address1);
        type(address2Input, AuthCredentials.Address2);
        selectDropdownByVisibleText(countryDropdown, AuthCredentials.Country);
        type(stateInput, AuthCredentials.State);
        type(cityInput, AuthCredentials.City);
        type(zipcodeInput, AuthCredentials.Zipcode);
        type(mobileNumberInput, AuthCredentials.MobileNumber);

        click(createAccountButton);
    }

    public void inValidSignup() {
        type(signupNameInput, AuthCredentials.Name);
        type(signupEmailInput, AuthCredentials.RegisteredEmail);
        click(signupButton);
    }

    public boolean verifyNewUserSignupTitleIsVisible() {
        return isVisible(newUserSignupTitle)
                && newUserSignupTitle.getText().equalsIgnoreCase(
                "New User Signup!");
    }

    public boolean verifySignupErrorMessageIsVisible() {
        return isVisible(signupErrorMessage)
                && signupErrorMessage.getText().equalsIgnoreCase(
                "Email Address already exist!");
    }

    public boolean verifyEnterAccountInformationIsVisible() {
        return isVisible(enterAccountInformation)
                && enterAccountInformation.getText().equalsIgnoreCase(
                "Enter Account Information");
    }

    public boolean verifyAccountCreatedIsVisible() {
        return isVisible(accountCreated)
                && accountCreated.getText().equalsIgnoreCase(
                "Account Created!");
    }
}
