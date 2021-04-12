package com.amazon;

import com.amazon.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends BaseTest {

    private static final String CURRENCY = PropertyManager.getProperty("currencyPage.currency");
    private static final String MESSAGE = PropertyManager.getProperty("currencyPage.messageShort");

    @Test
    public void changeCurrency(){
        homePage.open().changeCurrency();
        currencySettingPage.selectCurrency(CURRENCY);

        System.out.println(MESSAGE);
        Assert.assertTrue(currencySettingPage.pageSource().contains(MESSAGE));
    }
}
