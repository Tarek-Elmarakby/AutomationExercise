package BaseTest;

import org.example.Pages.*;
import org.example.Utilities.FileDownloader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    //FileDownloader
    protected FileDownloader fileDownloader;
    private final String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";

    // Page Objects
    protected HomePage homePage;
    protected ProductsPage productsPage;
    protected ProductDetailPage productDetailPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected PaymentPage paymentPage;
    protected TestCasesPage testCasesPage;
    protected ContactUsPage contactUsPage;

    @BeforeMethod
    public void setUp() {
        // Configure Chrome to auto-download files
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        fileDownloader = new FileDownloader(downloadPath);

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");

        // Initialize page objects
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        testCasesPage = new TestCasesPage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        fileDownloader.cleanupDownloads();  // Delete downloaded files
        if (driver != null) {
            driver.quit();
        }
    }
}