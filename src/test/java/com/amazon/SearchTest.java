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

    private static final String SEARCH_PHRASE = PropertyManager.getProperty("search.phrase");
    private static final String ITEMS = PropertyManager.getProperty("expected.items");

    private static final List<String> booksTitles = Collections.singletonList(ITEMS);

    @Test
    public void basicAmazonProductSearch() {
        homePage.open()
                .dontChangeCountry()
                .searchProduct(SEARCH_PHRASE);
       assertItemInBreadcrumbs(SEARCH_PHRASE);
       assertItemsInResult(booksTitles);
    }

    private void assertItemInBreadcrumbs(String item) {
        TextAsserts.assertThatElementContainsText(SearchResultsPage.searchResultsBreadcrumbs, item.toLowerCase(Locale.ROOT), driver);
    }

    private void assertItemsInResult(List<String> booksTitles){
        booksTitles.forEach(str -> Assert.assertTrue(searchResultsPage.pageSource().contains(str)));
    }
}
