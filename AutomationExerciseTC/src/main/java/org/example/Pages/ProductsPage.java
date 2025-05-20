package org.example.Pages;

import org.example.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "h2.title.text-center")
    private WebElement productsHeaderTitle;

    @FindBy(partialLinkText = "View Product")
    private List<WebElement> viewProductLink;

    @FindBy(css = "div.features_items div.col-sm-4")
    private List<WebElement> productItems;

    @FindBy(css = "a.add-to-cart")
    private List<WebElement> addToCartButtons;

    @FindBy(css = "button.btn-success[data-dismiss='modal']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//u[text()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(css = "input#search_product")
    private WebElement searchInput;

    @FindBy(css = "button#submit_search")
    private WebElement searchButton;

    @FindBy(css = "div.productinfo.text-center p")
    private List<WebElement> productNames;

    @FindBy(xpath = "//h2[text()='Brands']")
    private WebElement brandsTitle;

    @FindBy(css = "a[href='/brand_products/Polo']")
    private WebElement poloBrandLink;

    @FindBy(css = "a[href='/brand_products/Madame']")
    private WebElement madameBrandLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickViewProductLink(int index) {
        click(viewProductLink.get(index));
    }

    public void addProductToCart(int productIndex, int cartButtonIndex) {
        hoverAndClick(productItems.get(productIndex), addToCartButtons.get(cartButtonIndex));
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
    }

    public void clickViewCartButton() {
        click(viewCartButton);
    }

    public void searchForProduct(String searchTerm) {
        type(searchInput, searchTerm);
        click(searchButton);
    }

    public void clickPoloBrandLink() {
        click(poloBrandLink);
    }

    public void clickMadameBrandLink() {
        click(madameBrandLink);
    }

    public boolean verifyProductsHeaderTitleIsVisible(String title) {
        return isVisible(productsHeaderTitle)
                && productsHeaderTitle.getText().equalsIgnoreCase(title);
    }

    public boolean verifyProductsListAreVisible() {
        return areAllVisible(productItems);
    }

    public boolean verifySearchedProductsTitleIsVisible() {
        return isVisible(productsHeaderTitle)
                && productsHeaderTitle.getText().equalsIgnoreCase(
                "SEARCHED PRODUCTS");
    }

    public boolean verifyProductResultsAreRelatedToSearch(String searchTerm) {
        return productNames.stream()
                .allMatch(element -> element.getText().toLowerCase()
                        .contains(searchTerm.toLowerCase()));
    }

    public boolean verifyBrandsSectionTitleIsVisible() {
        return isVisible(brandsTitle)
                && brandsTitle.getText().equalsIgnoreCase(
                "Brands");
    }
}
