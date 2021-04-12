package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Beyond Order: 12 More Rules for Life')]")
    public static WebElement searchedItem;

    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SearchResultsPage choseItem() {
        clickOnElement(searchedItem);
        return this;
    }

    public String pageSource() {
        return getPageSource();
    }
}
