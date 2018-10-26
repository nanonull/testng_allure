package com.qa_test_lab;

import com.qa_test_lab.web.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class HomePageTest extends AbstractTest {


    @Test
    public void testGuestUserCanSeeProductCatalogue() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assertions.assertThat(homePage.getProductCatalogueMainMenuRowNames())
                .as("Product Catalogue Main Menu Rows mismatch")
                .hasSize(17);
    }

    @Test(enabled = false)
    public void testUserCanSignIn() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickSignInButton();
        // TODO: 25.10.2018 provide test user/password
    }

}

