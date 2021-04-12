package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTotalPage extends BasePage{

    public SubTotalPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    public static WebElement cartButton;

    public SubTotalPage goToCart(){
        clickOnElement(cartButton);
        return this;
    }
}
