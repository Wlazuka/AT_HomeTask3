package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='ap_email']")
    private static WebElement emailField;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private static WebElement createAccountButton;
    @FindBy(xpath = "//input[@id='continue']")
    private static WebElement continueButton;
    @FindBy(xpath = "//input[@id='ap_password']")
    private static WebElement passwordField;
    @FindBy(xpath = "//input[@id='signInSubmit']")
    private static WebElement signInButton;


    public SignInPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SignInPage enterEmail(String text) {
        enterTextIntoField(emailField, text);
        return this;
    }

    public SignInPage pressContinueButton() {
        clickOnElement(continueButton);
        return this;
    }

    public SignInPage createAccount() {
        clickOnElement(createAccountButton);
        return this;
    }

    public SignInPage enterPassword(String text) {
        enterTextIntoField(passwordField, text);
        return this;
    }

    public SignInPage pressSingInButton() {
        clickOnElement(signInButton);
        return this;
    }

    public String pageSource() {
        return getPageSource();
    }
}
