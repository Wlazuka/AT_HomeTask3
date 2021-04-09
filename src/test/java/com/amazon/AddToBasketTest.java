package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToBasketTest extends BaseTest{

    private static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    private static final String AMAZON_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    private static final String SEARCH_FIELD_XPATH = "//input[@id='twotabsearchtextbox']";
    private static final String SEARCH_BUTTON_XPATH = "//input[@id='nav-search-submit-button']";
    private static final String SEARCH_TERM = "Jordan Peterson";
    private static final String HARDCOVER_BTN_XPATH = "//a[@id='a-autoid-2-announce']";
    private static final String QUANTITY_DRP_XPATH = "//select[@id='quantity']";
    private static final String ADD_TO_CART_BUTTON_XPATH = "//input[@id='add-to-cart-button']";
    private static final String CART_BUTTON_XPATH = "//a[@id='hlb-view-cart-announce']";
    private static final String SUBTOTAL_FILED_XPATH = "//div[@data-name='Subtotals']";

    private static final String BOOK = "//span[contains(text(),'Beyond Order: 12 More Rules for Life')]";

    @Test
    public void basicAmazonProductSearch(){
        driver.get(AMAZON_HOME_PAGE_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).clear();
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(SEARCH_TERM);
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();

        driver.findElement(By.xpath(BOOK)).click();
        driver.findElement(By.xpath(HARDCOVER_BTN_XPATH)).click();
        Select drpQty = new Select(driver.findElement(By.xpath(QUANTITY_DRP_XPATH)));
        drpQty.selectByValue("2");
        driver.findElement(By.xpath(ADD_TO_CART_BUTTON_XPATH)).click();
        driver.findElement(By.xpath(CART_BUTTON_XPATH)).click();

        WebElement subtotal = driver.findElement(By.xpath(SUBTOTAL_FILED_XPATH));
        Assert.assertEquals(subtotal.getText(), "Subtotal (2 items): $34.80");
    }
}

