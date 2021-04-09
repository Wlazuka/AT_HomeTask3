package com.amazon;

import com.amazon.pageobject.HomePage;
import com.amazon.pageobject.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    static WebDriver driver;
    static final String CHROME_DRIVER_PATH = "drivers/chromedriver";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9225");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
