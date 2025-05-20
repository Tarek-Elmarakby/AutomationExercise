package org.example.Pages;

import org.example.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    private WebElement getInTouchTitle;

    @FindBy(css = "input[data-qa='name']")
    private WebElement nameInput;

    @FindBy(css = "input[data-qa='email']")
    private WebElement emailInput;

    @FindBy(css = "input[data-qa='subject']")
    private WebElement subjectInput;

    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(name = "upload_file")
    private WebElement uploadFileButton;

    @FindBy(css = "input[data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm() {
        type(nameInput, "Test User");
        type(emailInput, "test@example.com");
        type(subjectInput, "Test Subject");
        type(messageInput, "This is a test message");
        uploadFile(uploadFileButton);
        click(submitButton);
        alertAccept();
    }

    public boolean verifyContactUsPageIsVisible() {
        return isVisible(getInTouchTitle)
                && getInTouchTitle.getText().equalsIgnoreCase("Get In Touch");
    }

    public boolean verifySuccessMessageIsVisible() {
        return isVisible(successMessage)
                && successMessage.getText().equalsIgnoreCase(
                "Success! Your details have been submitted successfully.");
    }
}
