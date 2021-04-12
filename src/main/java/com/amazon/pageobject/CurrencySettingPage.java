package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencySettingPage extends BasePage {

    @FindBy(xpath = "//select[@id='icp-sc-dropdown']")
    public static WebElement currencyDrp;

    @FindBy(xpath = "//span[contains(text(),'Save changes')]")
    private static WebElement saveButton;

    public CurrencySettingPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public CurrencySettingPage selectCurrency(String currency) {
        selectFromDropdownByText(currencyDrp, currency);
        return this;
    }

    public String pageSource(){
        return getPageSource();
    }

    public CurrencySettingPage saveSettings() {
        clickOnElement(saveButton);
        return this;
    }
}
