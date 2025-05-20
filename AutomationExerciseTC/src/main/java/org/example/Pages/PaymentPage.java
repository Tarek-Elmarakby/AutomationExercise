package org.example.Pages;

import org.example.Credentials.PaymentCredentials;
import org.example.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    // Elements for payment page
    @FindBy(name = "name_on_card")
    private WebElement nameOnCardInput;

    @FindBy(name = "card_number")
    private WebElement cardNumberInput;

    @FindBy(name = "cvc")
    private WebElement cvcInput;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonthInput;

    @FindBy(name = "expiry_year")
    private WebElement expiryYearInput;

    @FindBy(id = "submit")
    private WebElement payAndConfirmButton;

    @FindBy(css = "p[style='font-size: 20px; font-family: garamond;']")
    private WebElement orderConfirmationMessage;

    @FindBy(css = "a[href^='/download_invoice/']")
    private WebElement downloadInvoiceButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void enterPaymentDetailsAndPay() {
        nameOnCardInput.sendKeys(PaymentCredentials.CARD_NAME);
        cardNumberInput.sendKeys(PaymentCredentials.CARD_NUMBER);
        cvcInput.sendKeys(PaymentCredentials.CARD_CVC);
        expiryMonthInput.sendKeys(PaymentCredentials.CARD_EXP_MONTH);
        expiryYearInput.sendKeys(PaymentCredentials.CARD_EXP_YEAR);
        click(payAndConfirmButton);
    }

    public void downloadInvoice() {
        click(downloadInvoiceButton);
    }

    public boolean verifyOrderConfirmationMessage() {
        return isVisible(orderConfirmationMessage)
                && orderConfirmationMessage.getText().equalsIgnoreCase(
                "Congratulations! Your order has been confirmed!");
    }
}