package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {


    @FindBy(xpath = "//a[@id='a-autoid-2-announce']")
    public static WebElement hardCoverButton;

    @FindBy(xpath = "//select[@id='quantity']")
    public static WebElement quantityDrp;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public static WebElement adToCArtButton;

    public ProductDetailsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public ProductDetailsPage choseHardCover() {
        clickOnElement(hardCoverButton);
        return this;
    }

    public ProductDetailsPage selectQuantity(String quantity) {
        selectFromDropdownByText(quantityDrp, quantity);
        return this;
    }

    public ProductDetailsPage addToCart(){
        clickOnElement(adToCArtButton);
        return this;
    }

}
