package org.example.Pages;

import org.example.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "tr[id^='product-']")
    private List<WebElement> cartItems;

    @FindBy(css = "td[class^='cart_product']")
    private List<WebElement> cartItemsImage;

    @FindBy(css = "td[class^='cart_description']")
    private List<WebElement> cartItemsDescription;

    @FindBy(css = "td[class^='cart_price']")
    private List<WebElement> cartItemsPrice;

    @FindBy(css = "td[class^='cart_quantity']")
    private List<WebElement> cartItemsQuantity;

    @FindBy(css = "button.disabled")
    private List<WebElement> itemQuantity;

    @FindBy(css = "P[class^='cart_total_price']")
    private List<WebElement> cartItemsTotalPrice;

    @FindBy(css = "a[class*='cart_quantity_delete']")
    private List<WebElement> deleteButtons;

    @FindBy(css = "a.check_out")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "li.active")
    private WebElement shoppingCartTitle;

    @FindBy(id = "empty_cart")
    private WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeProductFromCart(int index) {
        click(deleteButtons.get(index));
    }

    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }

    public boolean verifyShoppingCartTitleIsDisplayed() {
        return isVisible(shoppingCartTitle)
                && shoppingCartTitle.getText().equalsIgnoreCase("Shopping Cart");
    }

    public boolean verifyCartItemsAreDisplayed(int expectedNumberOfItems) {
        return areAllVisible(cartItems)
                && cartItems.size() == expectedNumberOfItems
                && cartItemsImage.size() == expectedNumberOfItems
                && cartItemsDescription.size() == expectedNumberOfItems
                && cartItemsPrice.size() == expectedNumberOfItems
                && cartItemsQuantity.size() == expectedNumberOfItems
                && cartItemsTotalPrice.size() == expectedNumberOfItems;
    }

    public boolean verifyItemQuantityInCart(int itemIndex, int expectedItemQuantity) {
        return verifyQuantity(itemQuantity, itemIndex, expectedItemQuantity);
    }

    public boolean verifyEmptyCartMessageIsVisible() {
        return isVisible(emptyCartMessage)
                && emptyCartMessage.getText().equalsIgnoreCase(
                "Cart is empty! Click here to buy products.");
    }
}
