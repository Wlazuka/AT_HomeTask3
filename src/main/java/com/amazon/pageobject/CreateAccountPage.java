package com.amazon.pageobject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    public CreateAccountPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private static WebElement nameFiled;

    @FindBy(xpath = "//input[@id='ap_email']")
    private static WebElement emailField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private static WebElement passwordFiled;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private static WebElement reEnterPasswordFiled;

    @FindBy(xpath = "//input[@id='continue']")
    private static WebElement createAccountButton;

    public CreateAccountPage enterName(String text) {
        enterTextIntoField(nameFiled, text);
        return this;
    }

    public CreateAccountPage enterEmail(String text) {
        enterTextIntoField(emailField, text);
        return this;
    }

    public CreateAccountPage enterPassword(String text) {
        enterTextIntoField(passwordFiled, text);
        return this;
    }

    public CreateAccountPage reEnterPassword(String text) {
        enterTextIntoField(reEnterPasswordFiled, text);
        return this;
    }

    public CreateAccountPage createAccount() {
        clickOnElement(createAccountButton);
        return this;
    }

    public String pageSource(){
        return getPageSource();
    }
}
