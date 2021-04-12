package com.amazon;

import com.amazon.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private static final String SEARCH_PHRASE = PropertyManager.getProperty("search.phrase");
    private static final String ITEMS = PropertyManager.getProperty("expected.items");

    @DataProvider (name = "data-provider")
    public Object[][] createData1() {
        return new Object[][]{
                {"Beyond Order: 12 More Rules for Life"},
                {"12 Rules for Life: An Antidote to Chaos"},
                {"Maps of Meaning"},
                {"The Rise Of Jordan Peterson"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void productSearch(String title) {
        homePage.open()
                .dontChangeCountryIfRequired()
                .searchProduct(SEARCH_PHRASE);
        Assert.assertTrue(searchResultsPage.pageSource().contains(title));
    }
}
