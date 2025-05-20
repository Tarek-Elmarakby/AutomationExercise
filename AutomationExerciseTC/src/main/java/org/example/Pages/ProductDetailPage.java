package org.example.Pages;

import org.example.BasePage.BasePage;
import org.example.Credentials.AuthCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

    @FindBy(css = "div.product-information h2")
    private WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category:')]")
    private WebElement category;

    @FindBy(xpath = "//span[contains(text(), 'Rs.')]")
    private WebElement price;

    @FindBy(xpath = "//*[@id=\"quantity\"]")
    private WebElement quantityInput;

    @FindBy(xpath = "//p[contains(., 'Availability:')]")
    private WebElement availability;

    @FindBy(xpath = "//p[b[text()='Condition:']]")
    private WebElement condition;

    @FindBy(xpath = "//p[b[text()='Brand:']]")
    private WebElement brand;

    @FindBy(css = "button[type='button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//u[text()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(css = "a[href='#reviews']")
    private WebElement reviewsHeaderTitle;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "review")
    private WebElement reviewInput;

    @FindBy(id = "button-review")
    private WebElement submitReview;

    @FindBy(css = "div.alert-success.alert span")
    private WebElement reviewSuccessMessage;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addReviewOnProduct() {
        type(nameInput, AuthCredentials.Name);
        type(emailInput, AuthCredentials.Email);
        type(reviewInput, AuthCredentials.Review);
        click(submitReview);
    }

    public void updateQuantity(String quantity) {
        type(quantityInput, quantity);
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }

    public void clickViewCartButton() {
        click(viewCartButton);
    }

    public boolean verifyProductDetailIsVisible() {
        return isVisible(productName) &&
                isVisible(category) &&
                isVisible(price) &&
                isVisible(availability) &&
                isVisible(condition) &&
                isVisible(brand);
    }

    public boolean verifyReviewHeaderIsVisible() {
        return isVisible(reviewsHeaderTitle)
                && reviewsHeaderTitle.getText().equalsIgnoreCase(
                "Write Your Review");
    }

    public boolean verifyReviewSuccessMessage() {
        return isVisible(reviewSuccessMessage)
                && reviewSuccessMessage.getText().equalsIgnoreCase(
                "Thank you for your review.");
    }
}