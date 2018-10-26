package com.qa_test_lab;

import com.qa_test_lab.web.CartPanel;
import com.qa_test_lab.web.HeaderMenuPanel;
import com.qa_test_lab.web.ProductDetailsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderTest extends AbstractTest {

    @DataProvider(name = "Products_to_buy")
    public static Object[][] credentials() {
        return new Object[][]{
                {"sheriff_zx_1070/p995964", 2330},
                {"asus_x570ud_e4037/p31282079/", 25999}
        };
    }

    @Test(dataProvider = "Products_to_buy")
    public void testUserCanOrderProduct(String productLink, int productPrice) {
        ProductDetailsPage detailsPage = new ProductDetailsPage(driver);
        detailsPage.openByLink(productLink);
        Assertions.assertThat(detailsPage.getProductPrice())
                .as("Product Price mismatch").isEqualTo(productPrice);
        detailsPage.clickOrderButton();
        Assertions.assertThat(new CartPanel(driver).isDisplayed())
                .as("Cart Popup is not displayed").isTrue();

        Assertions.assertThat(new HeaderMenuPanel(driver).getItemsInCartAmount())
                .as("Mismatch product amount in cart").isEqualTo(1);
    }

}
