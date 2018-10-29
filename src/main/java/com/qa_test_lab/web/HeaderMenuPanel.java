package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuPanel extends AbstractPage {

    @FindBy(id = "cart_popup_header")
    private WebElement cartButton;
    @FindBy(className = "hub-i-count")
    private WebElement cartProductsAmount;

    public HeaderMenuPanel(WebDriver driver) {
        super(driver, HomePage.BASE_URL);
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public int getItemsInCartAmount() {
        return Integer.parseInt(cartProductsAmount.getText());
    }

}
