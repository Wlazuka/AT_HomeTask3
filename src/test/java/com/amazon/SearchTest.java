package com.amazon;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SearchTest extends BaseTest {

    private static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    private static final String AMAZON_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    private static final String SEARCH_FIELD_XPATH = "//input[@id='twotabsearchtextbox']";
    private static final String SEARCH_TERM = "Jordan Peterson";
    private static final String SEARCH_BUTTON_XPATH = "//input[@id='nav-search-submit-button']";
    private static final String SEARCH_RESULTS_BREADCRUMB_XPATH = "//span[contains(text(),\"jordan peterson\")]";

    private static final List<String> booksTitles = Arrays.asList("Beyond Order: 12 More Rules for Life", "12 Rules for Life: An Antidote to Chaos", "Maps of Meaning");

    @Test
    public void basicAmazonProductSearch(){
        driver.get(AMAZON_HOME_PAGE_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).clear();
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(SEARCH_TERM);
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();

        Assert.assertTrue(driver.findElement(By.xpath(SEARCH_RESULTS_BREADCRUMB_XPATH)).isDisplayed());
        booksTitles.forEach(str -> Assert.assertTrue(driver.getPageSource().contains(str)));
    }
}
