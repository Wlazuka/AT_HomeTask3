package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrencySettingPage extends BasePage{

    private static final String CURRENCY_PAGE_TITLE = PropertyManager.getProperty("currencyPage.title");
    private static final String MESSAGE = PropertyManager.getProperty("currencyPage.message");

    @FindBy(xpath = "//select[@id='icp-sc-dropdown']")
    public static WebElement CURRENCY_DROPDOWN;

    @FindBy(xpath = "//span[contains(text(),'Save changes')]")
    private static WebElement SAVE_BUTTON;

    public CurrencySettingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
