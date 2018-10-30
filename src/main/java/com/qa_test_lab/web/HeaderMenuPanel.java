package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import com.qa_test_lab.web.base.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HeaderMenuPanel extends AbstractPanel {

    @FindBy(id = "cart_popup_header")
    private WebElement cartButton;
    @FindBy(className = "hub-i-count")
    private WebElement cartProductsAmount;

    public HeaderMenuPanel(WebDriver driver) {
        super(driver, By.className("header-user-buttons"));
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public int getItemsInCartAmount() {
        return Integer.parseInt(cartProductsAmount.getText());
    }

    public void waitCartHasProductsAmount(int productsInCart) {
        new FluentWait<>(this)
                .withMessage("Cart Product amount mismatch in menu header")
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(WebHelper.PAGE_LOAD_TIMEOUT_SEC))
                .until(panel -> panel.getItemsInCartAmount() == productsInCart);
    }
}
