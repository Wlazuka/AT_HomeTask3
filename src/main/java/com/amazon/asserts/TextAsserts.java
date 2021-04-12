package com.amazon.asserts;

import com.amazon.actions.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TextAsserts {

    private TextAsserts() {
    }

    public static void assertThatTextIsPresentInField(WebElement element, String expectedText, WebDriver driver) {
        Assert.assertEquals(Elements.waitForElemnentToBeVisible(element, driver).getText(), expectedText);
    }
}
