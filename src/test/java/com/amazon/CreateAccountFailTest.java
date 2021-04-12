package com.amazon;

import com.amazon.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountFailTest extends BaseTest{

    private static final String NAME = PropertyManager.getProperty("name");
    private static final String EMAIL = PropertyManager.getProperty("email");
    private static final String PASSWORD = PropertyManager.getProperty("password");
    private static final String INCORECT_PASSWORD = PropertyManager.getProperty("incotect_password");
    private static final String EXPECTED_MSG = PropertyManager.getProperty("createAccount.errorMsg");

    @Test
    public void creatingAccountFailTest() {
        homePage.open().signIn();
        signInPage.createAccount();
        createAccountPage
                .enterName(NAME)
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .reEnterPassword(INCORECT_PASSWORD)
                .createAccount();

        Assert.assertTrue(createAccountPage.pageSource().contains(EXPECTED_MSG));
    }
}
