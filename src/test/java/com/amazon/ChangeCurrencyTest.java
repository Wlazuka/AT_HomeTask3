package com.amazon;

import com.amazon.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends BaseTest {


    @Test
    public void changeCurrency() {
        driver.get(AMAZON_HOME_PAGE_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);
        driver.findElement(By.xpath(CHANGE_LANGUAGE_BTN_XPATH)).click();
        String languagePageTitle = driver.getTitle();
        Assert.assertEquals(languagePageTitle, AMAZON_LANGUAGE_PAGE_TITLE);

        Select drpCurrency = new Select(driver.findElement(By.xpath(CURRENCY_DROPDOWN_XPATH)));
        drpCurrency.selectByVisibleText("€ - EUR - Euro");
        Assert.assertTrue(driver.getPageSource().contains(NOTE));


    }

}
