package com.amazon;

import com.amazon.asserts.TextAsserts;
import com.amazon.utils.PropertyManager;
import org.testng.annotations.Test;

public class AddToBasketTest extends BaseTest {

    private static final String ITEM = PropertyManager.getProperty("search.item");
    private static final String MESSAGE = PropertyManager.getProperty("cart.message");

    @Test
    public void basicAmazonProductSearch() {
        homePage.open()
                .searchProduct(ITEM);
        searchResultsPage.choseItem();
        productDetailsPage.choseHardCover().selectQuantity("2").addToCart();
        subTotalPage.goToCart();
        checkSubtotalText();
    }

    private void checkSubtotalText() {
        TextAsserts.assertThatTextIsPresentInField(cartPage.subtotalFiled, MESSAGE, driver);
    }
}

