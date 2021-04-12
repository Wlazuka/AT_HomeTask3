package com.amazon;

import com.amazon.pageobject.*;
import com.amazon.utils.PropertyManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    static final String CHROME_DRIVER_PATH = "drivers/chromedriver";
    static WebDriver driver;
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected CurrencySettingPage currencySettingPage;
    protected CreateAccountPage createAccountPage;
    protected SignInPage signInPage;
    protected ProductDetailsPage productDetailsPage;
    protected SubTotalPage subTotalPage;
    protected CartPage cartPage;
    protected PropertyManager propertyManager;
    protected JavascriptExecutor js;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9225");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        js = (JavascriptExecutor) driver;
        propertyManager = new PropertyManager();

        homePage = new HomePage(driver, propertyManager);
        searchResultsPage = new SearchResultsPage(driver, propertyManager);
        signInPage = new SignInPage(driver, propertyManager);
        currencySettingPage = new CurrencySettingPage(driver, propertyManager);
        createAccountPage = new CreateAccountPage(driver, propertyManager);
        productDetailsPage = new ProductDetailsPage(driver, propertyManager);
        subTotalPage = new SubTotalPage(driver, propertyManager);
        cartPage = new CartPage(driver, propertyManager);
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}
