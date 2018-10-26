package com.qa_test_lab;

import com.qa_test_lab.web.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    @Test(enabled = false)
    public void testUserCanSignIn() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickSignInButton();
        // TODO: 25.10.2018 provide test user/password
    }

}

