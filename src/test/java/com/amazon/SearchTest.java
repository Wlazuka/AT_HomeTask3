package com.amazon;

import com.amazon.asserts.TextAsserts;
import com.amazon.pageobject.SearchResultsPage;
import com.amazon.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SearchTest extends BaseTest {

    private static final String ITEM = PropertyManager.getProperty("search.item");
    private static final String ITEMS = PropertyManager.getProperty("search.items");

//    private static final List<String> booksTitles = Collections.singletonList(ITEMS);

    @Test
    public void basicAmazonProductSearch() {
        homePage.open()
                .searchProduct(ITEM);
       assertItemInBreadcrumbs(ITEM);
    }

    private void assertItemInBreadcrumbs(String item) {
        TextAsserts.assertThatTextIsPresentInField(SearchResultsPage.searchResultsBreadcrumbs, item.toLowerCase(Locale.ROOT), driver);
    }
}
