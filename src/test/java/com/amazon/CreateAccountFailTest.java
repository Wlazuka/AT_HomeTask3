package com.amazon;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountFailTest extends BaseTest{

    private static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    private static final String AMAZON_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    private static final String AMAZON_SIGNIN_PAGE_TITLE = "Amazon Sign-In";
    private static final String SIGNIN_LINK_XPATH = "//a[@id='nav-link-accountList']";
    private static final String AMAZON_REGISTRATION_PAGE_TITLE = "Amazon Registration";

    private static final String NAME_FILED_XPATH = "//input[@id='ap_customer_name']";
    private static final String EMAIL_FILED_XPATH = "//input[@id='ap_email']";
    private static final String PASSWORD_FILED_XPATH = "//input[@id='ap_password']";
    private static final String RE_PASSWORD_FILED_XPATH = "//input[@id='ap_password_check']";
    private static final String CREATE_ACCOUNT_BUTTON_XPATH = "//a[@id='createAccountSubmit']";
    private static final String CONTINUE_BUTTON_XPATH = "//input[@id='continue']";

    private static final String EXPECTED_MSG = "//div[contains(text(),'Passwords must match')]";

    private static final String NAME = PropertyManager.getProperty("name");
    private static final String EMAIL = PropertyManager.getProperty("email");
    private static final String PASSWORD = PropertyManager.getProperty("password");
    private static final String RE_PASSWORD = PropertyManager.getProperty("wrong_password");

    @Test
    public void creatingAccountFailTest() {
        driver.get(AMAZON_HOME_PAGE_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);

        driver.findElement(By.xpath(SIGNIN_LINK_XPATH)).click();
        String sigInPageTitle = driver.getTitle();
        Assert.assertEquals(sigInPageTitle,AMAZON_SIGNIN_PAGE_TITLE);

        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON_XPATH)).click();
        String registrationPageTitle = driver.getTitle();
        Assert.assertEquals(registrationPageTitle, AMAZON_REGISTRATION_PAGE_TITLE);

        driver.findElement(By.xpath(NAME_FILED_XPATH)).clear();
        driver.findElement(By.xpath(NAME_FILED_XPATH)).sendKeys(NAME);
        driver.findElement(By.xpath(EMAIL_FILED_XPATH)).clear();
        driver.findElement(By.xpath(EMAIL_FILED_XPATH)).sendKeys(EMAIL);
        driver.findElement(By.xpath(PASSWORD_FILED_XPATH)).clear();
        driver.findElement(By.xpath(PASSWORD_FILED_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(RE_PASSWORD_FILED_XPATH)).clear();
        driver.findElement(By.xpath(RE_PASSWORD_FILED_XPATH)).sendKeys(RE_PASSWORD);
        driver.findElement(By.xpath(CONTINUE_BUTTON_XPATH)).click();

        Assert.assertTrue(driver.findElement(By.xpath(EXPECTED_MSG)).isDisplayed());
    }

}
