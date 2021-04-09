package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = PropertyManager.getProperty("homepage.url");
    private static final String PAGE_TITLE = PropertyManager.getProperty("homepage.title");

    @FindBy(xpath = "//input[@id='store_nav_search_term']")
    public static WebElement SEARCH_FIELD;

    @FindBy (xpath = "//a[@id='icp-nav-flyout']")
    public static WebElement CHANGE_LANGUAGE_BTN;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public HomePage open() {
        openWebPage(HOME_PAGE_URL);
        checkPageTitle(PAGE_TITLE);
//        wait.forPageToLoad();
        return this;
    }

    public HomePage searchProduct(String gameTitle) {
        enterTextIntoField(SEARCH_FIELD, gameTitle);
        pressKey(Keys.ENTER);
        return this;
    }
}

