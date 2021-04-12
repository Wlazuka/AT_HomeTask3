package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTotalPage extends BasePage {

    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    public static WebElement cartButton;

    public SubTotalPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SubTotalPage goToCart() {
        clickOnElement(cartButton);
        return this;
    }
}
