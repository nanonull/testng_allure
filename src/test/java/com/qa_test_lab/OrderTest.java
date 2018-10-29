package com.qa_test_lab;

import com.qa_test_lab.base.AbstractTest;
import com.qa_test_lab.base.TestListener;
import com.qa_test_lab.web.CartPanel;
import com.qa_test_lab.web.HeaderMenuPanel;
import com.qa_test_lab.web.ProductDetailsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class OrderTest extends AbstractTest {

    @DataProvider
    public static Object[][] products() {
        return new Object[][]{
                {"sheriff_zx_1070/p995964", 2330},
                {"asus_x570ud_e4037/p31282079/", 25999}
        };
    }

    @Test(dataProvider = "products")
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

    @Test
    public void testProductsInCart() {
        String[] products = {"/dell_cel3060_4_500_dvd/p18581717/", "/kingston_datatraveler_se9_16gb/p200095/"};
        ProductDetailsPage detailsPage = new ProductDetailsPage(driver);
        HeaderMenuPanel headerMenuPanel = new HeaderMenuPanel(driver);

        int productsInCart = 0;
        for (String product : products) {
            detailsPage.openByLink(product);
            detailsPage.clickOrderButton();
            productsInCart++;
            headerMenuPanel.waitCartHasProductsAmount(productsInCart);
        }

        CartPanel cartPanel = new CartPanel(driver);
        Assertions.assertThat(cartPanel.getProductIds())
                .as("Cart Product Ids mismatch")
                .containsOnly(products[0], products[1]);
    }

}
