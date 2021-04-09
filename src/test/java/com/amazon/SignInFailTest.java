package com.amazon;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInFailTest extends BaseTest {

    private static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    private static final String AMAZON_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    private static final String AMAZON_SIGNIN_PAGE_TITLE = "Amazon Sign-In";
    private static final String SIGNIN_LINK_XPATH = "//a[@id='nav-link-accountList']";
    private static final String EMAIL_FILED_XPATH = "//input[@id='ap_email']";
    private static final String CONTINUE_BUTTON_XPATH = "//input[@id='continue']";
    private static final String PASSWORD_FILED_XPATH = "//input[@id='ap_password']";
    private static final String SUBMIT_BUTTON_XPATH = "//input[@id='signInSubmit']";

    private static final String EMAIL = PropertyManager.getProperty("email");
    private static final String PASSWORD = PropertyManager.getProperty("password");
    private static final String EXPECTED_MSG = "//div[contains(text(),'Enter the characters as they are given in the chal')]";

    @Test
    public void signInFailTest() {
        driver.get(AMAZON_HOME_PAGE_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);
        driver.findElement(By.xpath(SIGNIN_LINK_XPATH)).click();

        String sigInPageTitle = driver.getTitle();
        Assert.assertEquals(sigInPageTitle,AMAZON_SIGNIN_PAGE_TITLE);

        driver.findElement(By.xpath(EMAIL_FILED_XPATH)).clear();
        driver.findElement(By.xpath(EMAIL_FILED_XPATH)).sendKeys(EMAIL);
        driver.findElement(By.xpath(CONTINUE_BUTTON_XPATH)).click();

        driver.findElement(By.xpath(PASSWORD_FILED_XPATH)).clear();
        driver.findElement(By.xpath(PASSWORD_FILED_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();

        driver.findElement(By.xpath(PASSWORD_FILED_XPATH)).clear();
        driver.findElement(By.xpath(PASSWORD_FILED_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();

        Assert.assertTrue(driver.findElement(By.xpath(EXPECTED_MSG)).isDisplayed());
    }
}
