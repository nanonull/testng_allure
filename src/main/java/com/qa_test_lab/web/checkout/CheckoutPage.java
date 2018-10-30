package com.qa_test_lab.web.checkout;

import com.qa_test_lab.web.HomePage;
import com.qa_test_lab.web.base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage extends AbstractPage {

    @FindBy(id = "purchases_container")
    private WebElement checkoutMiniCart;
    @FindBy(css = "#purchases_container .bill-g-i div a")
    private List<WebElement> productItems;
    @FindBy(className = "check-edit-order-link")
    private WebElement editOrderLink;
    @FindBy(className = "bill-g-i-amount")
    private List<WebElement> productQuantities;

    public CheckoutPage(WebDriver driver) {
        super(driver,  "https://my.rozetka.com.ua/checkout");
    }

    public List<String> getProductIds() {
        return productItems.stream()
                .map(webElement -> webElement.getAttribute("href").replaceAll(HomePage.BASE_URL, ""))
                .collect(Collectors.toList());
    }

    public boolean isMiniCartDisplayed() {
        return checkoutMiniCart.isDisplayed();
    }

    public void clickEditCart() {
        editOrderLink.click();
    }


    public int getProductQty(int itemIndex) {
        return Integer.parseInt(productQuantities.get(itemIndex).getText().replaceAll("[^\\d]*", ""));
    }
}
