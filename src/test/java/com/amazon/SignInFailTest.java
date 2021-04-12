package com.amazon;

import com.amazon.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInFailTest extends BaseTest {
    private static final String EMAIL = PropertyManager.getProperty("email");
    private static final String PASSWORD = PropertyManager.getProperty("password");
    private static final String EXPECTED_MSG = PropertyManager.getProperty("signInPage.errorMsg");

    @Test
    public void signInFailTest() {
        homePage.open()
                .dontChangeCountry()
                .signIn();
        signInPage
                .enterEmail(EMAIL)
                .pressContinueButton()
                .enterPassword(PASSWORD)
                .pressSingInButton()
                .enterPassword(PASSWORD)
                .pressSingInButton();

        Assert.assertTrue(signInPage.pageSource().contains(EXPECTED_MSG));
    }
}
