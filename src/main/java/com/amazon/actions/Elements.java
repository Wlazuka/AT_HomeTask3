package com.amazon.actions;

import com.amazon.utils.LogUtil;
import com.amazon.utils.PropertyManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Elements {

    private static final Logger logger = LogManager.getLogger(PropertyManager.class.getSimpleName());

    private Elements() {
    }

    public static WebElement waitForElemnentToBeVisible(WebElement element, WebDriver driver){
        WebElement visibleElement = null;
        try{
            visibleElement = new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            LogUtil.logStackTrace(e, logger);
        }
        return visibleElement;
    }
}
