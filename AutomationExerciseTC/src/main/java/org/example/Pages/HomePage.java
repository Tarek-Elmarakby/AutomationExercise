package org.example.Pages;

import org.example.BasePage.BasePage;
import org.example.Credentials.AuthCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Features Items']")
    private WebElement featuresItemsTitle;

    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    private WebElement recommendedItemsTitle;

    @FindBy(xpath = "//h2[text()='Category']")
    private WebElement categoryHeader;

    @FindBy(css = "a[href='/'] > i.fa-home")
    private WebElement homeButton;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement LogoutButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
    private WebElement cartButton;

    @FindBy(css = "a[href='#Kids']")
    private WebElement kidsCategoryLink;

    @FindBy(css = "a[href='/category_products/4']")
    private WebElement dressCategoryLink;

    @FindBy(css = "a[href='#Men']")
    private WebElement menCategoryLink;

    @FindBy(css = "#recommended-item-carousel a.add-to-cart")
    private List<WebElement> recommendedItemAddToCartButton;

    @FindBy(css = "a[href='/category_products/3']")
    private WebElement tshirtsCategoryLink;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement testCasesButton;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(css = "h2[data-qa='account-deleted']")
    private WebElement accountDeletedMessage;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsUsername;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionFooterTitle;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmail;

    @FindBy(css = "i.fa-arrow-circle-o-right")
    private WebElement subscribeIcon;

    @FindBy(css = "div.alert-success.alert")
    private WebElement successAlert;

    @FindBy(id = "scrollUp")
    private WebElement scrollUp;

    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    private List<WebElement> firstFullFledgedHeading;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickHome() {
        click(homeButton);
    }

    public void clickSignupLogin() {
        click(signupLoginButton);
    }

    public void clickLogout() {
        click(LogoutButton);
    }

    public void clickProducts() {
        click(productsButton);
    }

    public void clickCart() {
        click(cartButton);
    }

    public void clickKidsDressCategoryLink() {
        click(kidsCategoryLink);
        click(dressCategoryLink);
    }

    public void clickMenTShirtsCategoryLink() {
        click(menCategoryLink);
        click(tshirtsCategoryLink);
    }

    public void scrollToRecommendedItemsSection() {
        scrollToElement(recommendedItemsTitle);
    }

    public void addToCartFromRecommendedItems(int index) {
        click(recommendedItemAddToCartButton.get(index));
    }

    public void clickContactUs() {
        click(contactUsButton);
    }

    public void clickTestCases() {
        click(testCasesButton);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }

    public void clickScrollUpArrow() {
        click(scrollUp);
    }

    public void scrollToSubscriptionFooter() {
        scrollToElement(subscriptionFooterTitle);
    }

    public void subscriptionByEmail() {
        type(subscribeEmail, AuthCredentials.Email);
        click(subscribeIcon);
    }

    public boolean verifyHomePageIsVisible() {
        return isVisible(featuresItemsTitle)
                && featuresItemsTitle.getText().equalsIgnoreCase(
                "Features Items");
    }

    public boolean verifyFirstFullFledgedHeadingIsVisible() {
        return areAllVisible(firstFullFledgedHeading);
    }

    public boolean verifyRecommendedItemsSectionIsVisible() {
        return isVisible(recommendedItemsTitle)
                && recommendedItemsTitle.getText().equalsIgnoreCase(
                "recommended items");
    }

    public boolean verifyLoggedInAsUsernameIsVisible() {
        return isVisible(loggedInAsUsername);
    }

    public boolean verifyAccountIsDeleted() {
        return isVisible(accountDeletedMessage)
                && accountDeletedMessage.getText().equalsIgnoreCase(
                "Account Deleted!");
    }

    public boolean verifyCategoryHeaderIsVisible() {
        return isVisible(categoryHeader)
                && categoryHeader.getText().equalsIgnoreCase(
                "Category");
    }

    public boolean verifySubscriptionFooterIsVisible() {
        return isVisible(subscriptionFooterTitle)
                && subscriptionFooterTitle.getText().equalsIgnoreCase(
                "Subscription");
    }

    public boolean verifySubscriptionSuccessAlertIsVisible() {
        return isVisible(successAlert)
                && successAlert.getText().equalsIgnoreCase(
                "You have been successfully subscribed!");
    }
}
