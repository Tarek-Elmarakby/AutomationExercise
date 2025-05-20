package org.example.Pages;

import org.example.BasePage.BasePage;
import org.example.Credentials.AuthCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//a[@href='/login' and contains(., 'Register / Login')]")
    private WebElement registerLoginLink;

    @FindBy(css = "ul[id='address_delivery']")
    private WebElement deliveryAddressSection;

    @FindBy(css = "ul[id='address_invoice']")
    private WebElement billingAddressSection;

    @FindBy(name = "message")
    private WebElement commentTextArea;

    @FindBy(css = "a[href='/payment']")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterLoginLink() {
        click(registerLoginLink);
    }

    public void enterCommentAndPlaceOrder() {
        type(commentTextArea, AuthCredentials.Comment);
        click(placeOrderButton);
    }

    public boolean verifyDeliveryAddressIsCorrect() {
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressSection));
        return deliveryAddressSection.getText().contains(AuthCredentials.FirstName)
                && deliveryAddressSection.getText().contains(AuthCredentials.LastName)
                && deliveryAddressSection.getText().contains(AuthCredentials.Address1)
                && deliveryAddressSection.getText().contains(AuthCredentials.Address2)
                && deliveryAddressSection.getText().contains(AuthCredentials.City)
                && deliveryAddressSection.getText().contains(AuthCredentials.State)
                && deliveryAddressSection.getText().contains(AuthCredentials.Zipcode)
                && deliveryAddressSection.getText().contains(AuthCredentials.Country)
                && deliveryAddressSection.getText().contains(AuthCredentials.MobileNumber);
    }

    public boolean verifyBillingAddressIsCorrect() {
        wait.until(ExpectedConditions.visibilityOf(billingAddressSection));
        return billingAddressSection.getText().contains(AuthCredentials.FirstName)
                && billingAddressSection.getText().contains(AuthCredentials.LastName)
                && billingAddressSection.getText().contains(AuthCredentials.Address1)
                && billingAddressSection.getText().contains(AuthCredentials.Address2)
                && billingAddressSection.getText().contains(AuthCredentials.City)
                && billingAddressSection.getText().contains(AuthCredentials.State)
                && billingAddressSection.getText().contains(AuthCredentials.Zipcode)
                && billingAddressSection.getText().contains(AuthCredentials.Country)
                && billingAddressSection.getText().contains(AuthCredentials.MobileNumber);
    }
}
