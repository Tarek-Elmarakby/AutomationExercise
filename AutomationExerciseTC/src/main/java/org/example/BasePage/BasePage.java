package org.example.BasePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);  // Initialize Actions
        PageFactory.initElements(driver, this);
    }

    protected void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
    }

    protected void click(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clear(WebElement element) {
        scrollToElement(element);
        element.clear();
    }

    protected void type(WebElement element, String text) {
        clear(element);
        element.sendKeys(text);
    }

    protected void hoverAndClick(WebElement elementToHover, WebElement elementToClick) {
        scrollToElement(elementToHover);
        new Actions(driver)
                .moveToElement(elementToHover)
                .pause(1000)
                .click(elementToClick)
                .perform();
    }

    protected void hover(WebElement element) {
        scrollToElement(element);
        actions.moveToElement(element).perform();
    }

    protected void hoverWithOffset(WebElement element, int xOffset, int yOffset) {
        scrollToElement(element);
        actions.moveToElement(element, xOffset, yOffset).perform();
    }

    protected void selectDropdownByValue(WebElement element, String value) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Select(element).selectByValue(value);
    }

    protected void selectDropdownByVisibleText(WebElement element, String text) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Select(element).selectByVisibleText(text);
    }

    protected void uploadFile(WebElement element){
        scrollToElement(element);
        String filePath = new File("src/test/resources/invoice.pdf").getAbsolutePath();
        element.sendKeys(filePath);
    }

    protected void alertAccept() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    protected boolean isVisible(WebElement element) {
        scrollToElement(element);
        return element.isDisplayed();
    }

    protected boolean areAllVisible(List<WebElement> elements) {
        scrollToElement(elements.getFirst());
        return elements.stream()
                .allMatch(element -> wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed());
    }

    protected boolean verifyQuantity(List<WebElement> elements, int itemIndex, int expectedQuantity) {
        scrollToElement(elements.getFirst());
        return Integer.parseInt(elements.get(itemIndex).getText().trim()) == expectedQuantity;
    }
}
