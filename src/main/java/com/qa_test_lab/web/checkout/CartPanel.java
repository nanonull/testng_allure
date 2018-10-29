package com.qa_test_lab.web.checkout;

import com.qa_test_lab.web.HomePage;
import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPanel extends AbstractPanel {

    @FindBy(css = ".cart-i-content a[name=goods-link]")
    private List<WebElement> cartItemsLinks;
    @FindBy(id = "popup-checkout")
    private WebElement checkoutCartButton;
    @FindBy(css = ".cart-return-link a")
    private WebElement returnToShopping;
    @FindBy(className = "cart-amount-plus")
    private List<WebElement> cartItemPlus;
    @FindBy(css = "a[name=before_delete]")
    private List<WebElement> cartItemsRemove;

    public CartPanel(WebDriver driver) {
        super(driver, By.id("cart-popup"));
    }

    public void clickCheckoutCart() {
        checkoutCartButton.click();
    }

    public List<String> getProductIds() {
        List<String> ids = new ArrayList<>();
        for (WebElement cartItemLink : cartItemsLinks) {
            String link = cartItemLink.getAttribute("href");
            ids.add(link.replaceAll(HomePage.BASE_URL, ""));
        }
        return ids;
    }

    public void clickReturnToShopping() {
        returnToShopping.click();
    }

    public void clickItemPlus(int itemIndex) {
        cartItemPlus.get(itemIndex).click();
    }

    @FindBy(css = "[name=popup-move] .cart-i-delete-link")
    private WebElement deleteItem;

    public void removeItem(int itemIndex) {
        cartItemsRemove.get(itemIndex).click();
        deleteItem = null;
        updateStaleElements();
        deleteItem.click();
    }
}
