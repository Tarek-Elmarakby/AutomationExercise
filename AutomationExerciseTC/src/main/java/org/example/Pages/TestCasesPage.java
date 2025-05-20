package org.example.Pages;

import org.example.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage {

    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCasesBoldText;

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTestCasesPageIsVisible() {
        return isVisible(testCasesBoldText)
                && testCasesBoldText.getText().equalsIgnoreCase("Test Cases");
    }
}
