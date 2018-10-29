package com.qa_test_lab.steps;

import com.qa_test_lab.web.checkout.CartPanel;
import com.qa_test_lab.web.HeaderMenuPanel;
import com.qa_test_lab.web.ProductDetailsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderSteps {
    public static void addProductsToCart(WebDriver driver, String[] products) {
        ProductDetailsPage detailsPage = new ProductDetailsPage(driver);
        int productsInCart = 0;
        for (String product : products) {
            detailsPage.openByLink(product);
            detailsPage.clickOrderButton();
            productsInCart++;
            new HeaderMenuPanel(driver).waitCartHasProductsAmount(productsInCart);
        }
    }

    @Step
    public static void checkoutProducts(WebDriver driver, String[] products) {
        OrderSteps.addProductsToCart(driver, products);

        CartPanel cartPanel = new CartPanel(driver);
        assertThat(cartPanel.isDisplayed()).isTrue();
        cartPanel.clickCheckoutCart();

    }
}
