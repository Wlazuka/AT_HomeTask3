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

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public static WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public static WebElement searchButton;

    @FindBy (xpath = "//a[@id='icp-nav-flyout']")
    public static WebElement changeLanguageButton;

    @FindBy (xpath = "//a[@id='nav-link-accountList']")
    public static WebElement signInLink;


    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    public HomePage open() {
        openWebPage(HOME_PAGE_URL);
        checkPageTitle(PAGE_TITLE);
        return this;
    }

    public HomePage searchProduct(String item) {
        enterTextIntoField(searchField, item);
        clickOnElement(searchButton);
        return this;
    }

    public HomePage changeCurrency(){
        clickOnElement(changeLanguageButton);
        return this;
    }

    public HomePage signIn(){
        clickOnElement(signInLink);
        return this;
    }

}

