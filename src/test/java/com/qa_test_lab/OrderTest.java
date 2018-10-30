package com.qa_test_lab;

import com.qa_test_lab.base.AbstractTest;
import com.qa_test_lab.base.TestListener;
import com.qa_test_lab.steps.OrderSteps;
import com.qa_test_lab.web.base.WebHelper;
import com.qa_test_lab.web.checkout.CartPanel;
import com.qa_test_lab.web.checkout.CheckoutPage;
import com.qa_test_lab.web.HeaderMenuPanel;
import com.qa_test_lab.web.ProductDetailsPage;
import com.qa_test_lab.web.checkout.RemoveCartItemPanel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({TestListener.class})
public class OrderTest extends AbstractTest {

    @Test
    public void checkoutProducts() {
        String[] products = {"/dell_cel3060_4_500_dvd/p18581717/", "/kingston_datatraveler_se9_16gb/p200095/"};

        OrderSteps.addProductsToCart(driver, products);

        CartPanel cartPanel = new CartPanel(driver);
        assertThat(cartPanel.isDisplayed()).isTrue();
        assertThat(cartPanel.getProductIds())
                .as("Cart Product Ids mismatch")
                .containsOnly(products[0], products[1]);
        cartPanel.clickCheckoutCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertThat(checkoutPage.isDisplayed())
                .as("Checkout Page should be displayed").isTrue();
        assertThat(checkoutPage.isMiniCartDisplayed()).isTrue();
        assertThat(checkoutPage.getProductIds())
                .as("checkoutPage Product Ids mismatch")
                .containsOnly(products[0], products[1]);
    }


    @Test
    public void updateProductsDuringCheckout() {
        String[] products = {"/dell_cel3060_4_500_dvd/p18581717/", "/kingston_datatraveler_se9_16gb/p200095/"};

        OrderSteps.checkoutProducts(driver, products);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickEditCart();

        CartPanel cartPanel = new CartPanel(driver);
        assertThat(cartPanel.isDisplayed()).isTrue();
        assertThat(cartPanel.getProductIds())
                .as("Cart Product Ids mismatch")
                .containsOnly(products[0], products[1]);


        new CartPanel(driver).removeItem(1);
        WebHelper.repeatUntilSuccess(500, 4, ()->{
            cartPanel.updateStaleElements();
            assertThat(cartPanel.getProductIds())
                    .as("Cart Product Ids mismatch")
                    .containsOnly(products[1]);
            return true;
        });


        cartPanel.clickItemPlus(0);

        cartPanel.clickCheckoutCart();
        assertThat(cartPanel.isDisplayed()).isFalse();
        assertThat(checkoutPage.isDisplayed()).isTrue();
        assertThat(checkoutPage.getProductQty(0)).isEqualTo(2);
    }

}
